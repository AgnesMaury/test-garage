package services

import java.sql.{Connection, ResultSet, Timestamp}
import java.time.LocalDateTime
import java.util.UUID

import javax.inject.Inject
import model.{Car, Garage}
import models.DatabaseConstants._
import play.api.db._
import play.api.libs.json.Json.toJson
import play.api.mvc.Results._

import scala.collection.mutable.ListBuffer
import scala.util.{Failure, Success, Try}

class GarageService @Inject()(db: Database) {

  def createGarage(garage: Garage) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(CREATE_GARAGE)

      statement.setString(1, garage.id.toString)
      statement.setString(2, garage.name)
      statement.setString(3, garage.address)
      statement.setTimestamp(4, Timestamp.valueOf(garage.creationDate))
      statement.setInt(5, garage.maximumCapacity)

      statement.executeUpdate()
      Created(toJson(garage))
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def retrieveGarage(id: String) = {
    val connection = db.getConnection()
    val result = retrieveGarageFromDatabase(id, connection)
    connection.close()

    result match {
      case Failure(t) => InternalServerError(t.getMessage)
      case Success(None) => NotFound
      case Success(Some(garage)) => Ok(toJson(garage))
    }
  }

  def modifyGarage(garage: Garage) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(UPDATE_GARAGE)

      statement.setString(1, garage.name)
      statement.setString(2, garage.address)
      statement.setInt(3, garage.maximumCapacity)
      statement.setString(4, garage.id.toString)

      val result = statement.executeUpdate()
      if (result == 0) {
        NotFound
      } else {
        Ok(toJson(garage))
      }
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def deleteGarage(id: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(DELETE_GARAGE)

      statement.setString(1, id)
      statement.setString(2, id)

      statement.executeUpdate()
      Ok
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def retrieveAllCars(id: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(RETRIEVE_ALL_CARS_FROM_GARAGE)

      statement.setString(1, id)

      val result = statement.executeQuery()
      val cars = ListBuffer.empty[Car]

      while (result.next()) {
        cars.append(extractCarFromResult(result))
      }

      if (cars.isEmpty) {
        NotFound
      } else {
        Ok(toJson(cars.toList))
      }
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def addCarToGarage(car: Car) = {
    val connection = db.getConnection()
    try {
      isGarageFull(car.garageId.toString, connection) match {
        case Failure(t) => InternalServerError(t.getMessage)
        case Success(None) => NotFound
        case Success(Some(true)) => MethodNotAllowed
        case Success(Some(false)) =>
          val statement = connection.prepareStatement(CREATE_CAR_IN_GARAGE)

          statement.setString(1, car.id.toString)
          statement.setString(2, car.matriculation)
          statement.setString(3, car.brand)
          statement.setString(4, car.model)
          statement.setString(5, car.color)
          statement.setTimestamp(6, Timestamp.valueOf(LocalDateTime.from(car.commissioningDate.atStartOfDay())))
          statement.setDouble(7, car.price)
          statement.setString(8, car.garageId.toString)

          statement.executeUpdate()
          Created(toJson(car))
      }
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def deleteAllCarsOfGarage(id: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(DELETE_ALL_CARS_OF_GARAGE)

      statement.setString(1, id)

      statement.executeUpdate()
      Ok
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def retrieveCar(id: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(RETRIEVE_CAR)

      statement.setString(1, id)

      val result = statement.executeQuery()

      if (!result.next()) {
        NotFound
      } else {
        val car = extractCarFromResult(result)
        Ok(toJson(car))
      }
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def modifyCarMatriculation(id: String, matriculation: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(UPDATE_CAR_MATRICULATION)

      statement.setString(1, matriculation)
      statement.setString(2, id)

      statement.executeUpdate()
      Ok
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  def deleteCar(id: String) = {
    val connection = db.getConnection()
    try {
      val statement = connection.prepareStatement(DELETE_CAR)

      statement.setString(1, id)

      statement.executeUpdate()
      Ok
    } catch {
      case t: Throwable => InternalServerError(t.getMessage)
    } finally {
      connection.close()
    }
  }

  private def isGarageFull(id: String, connection: Connection): Try[Option[Boolean]] = {
    try {
      val garage = retrieveGarageFromDatabase(id, connection)

      garage match {
        case Success(Some(garage)) =>
          val statement = connection.prepareStatement(RETRIEVE_GARAGE_CAPACITY)

          statement.setString(1, garage.id.toString)

          val result = statement.executeQuery()
          Success(Some(result.getRow() >= garage.maximumCapacity))
        case Success(None) => Success(None)
        case Failure(t) => Failure(t)
      }
    } catch {
      case t: Throwable => Failure(t)
    }
  }

  private def extractCarFromResult(result: ResultSet) =
    Car(
      UUID.fromString(result.getString("id")),
      result.getString("matriculation"),
      result.getString("brand"),
      result.getString("model"),
      result.getString("color"),
      result.getTimestamp("commissioning_date").toLocalDateTime.toLocalDate,
      result.getDouble("price"),
      UUID.fromString(result.getString("garage_id"))
    )

  private def retrieveGarageFromDatabase(id: String, connection: Connection): Try[Option[Garage]] = {
    try {
      val statement = connection.prepareStatement(RETRIEVE_GARAGE)

      statement.setString(1, id)

      val result = statement.executeQuery()
      if (!result.next()) {
        Success(None)
      } else {
        val garage = Garage(
          UUID.fromString(result.getString("id")),
          result.getString("name"),
          result.getString("address"),
          result.getTimestamp("creation_date").toLocalDateTime,
          result.getInt("maximum_capacity")
        )

        Success(Some(garage))
      }
    } catch {
      case t: Throwable => Failure(t)
    }
  }
}
