package controllers

import java.util.UUID

import javax.inject.Inject
import model.{Car, Garage}
import models._
import play.api.libs.json._
import play.api.mvc._
import services.GarageService

import scala.util.{Failure, Success, Try}

class GarageController @Inject()(service: GarageService, cc: ControllerComponents) extends AbstractController(cc) {

  def createGarage() = Action { request =>
    request.body.asJson match {
      case None => BadRequest(MissingBodyError.message)
      case Some(json) => Garage.readGarage(json) match {
        case Success(garage) => service.createGarage(garage)
        case Failure(t) => BadRequest(DeserializeError(t).message)
      }
    }
  }

  def retrieveGarage(garageId: UUID) = Action { _ =>
    service.retrieveGarage(garageId.toString)
  }

  def modifyGarage(garageId: UUID) = Action { request =>
    request.body.asJson match {
      case None => BadRequest(MissingBodyError.message)
      case Some(json) => Garage.readGarage(json) match {
        case Success(garage) => service.modifyGarage(garage.copy(id = garageId))
        case Failure(t) => BadRequest(DeserializeError(t).message)
      }
    }
  }

  def deleteGarage(garageId: UUID) = Action { _ =>
    service.deleteGarage(garageId.toString)
  }

  def retrieveAllCars(garageId: UUID) = Action { _ =>
    service.retrieveAllCars(garageId.toString)
  }

  def addCarToGarage(garageId: UUID) = Action { request =>
    request.body.asJson match {
      case None => BadRequest(MissingBodyError.message)
      case Some(json) => Car.readCar(json) match {
        case Success(car) => service.addCarToGarage(car.copy(garageId = garageId))
        case Failure(t) => BadRequest(DeserializeError(t).message)
      }
    }
  }

  def deleteAllCarsOfGarage(garageId: UUID) = Action { _ =>
    service.deleteAllCarsOfGarage(garageId.toString)
  }

  def retrieveCarFromGarage(garageId: UUID, carId: UUID) = Action { _ =>
    service.retrieveCar(carId.toString)
  }

  def modifyCarMatriculation(garageId: UUID, carId: UUID) = Action { request =>
    request.body.asText match {
      case None => BadRequest(MissingBodyError.message)
      case Some(matriculation) => service.modifyCarMatriculation(carId.toString, matriculation)
    }
  }

  def deleteCarFromGarage(garageId: UUID, carId: UUID) = Action { _ =>
    service.deleteCar(carId.toString)
  }
}
