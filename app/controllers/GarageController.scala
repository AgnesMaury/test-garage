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
      case Some(json) => json.validate[Garage] match {
        case JsSuccess(garage, _) => service.createGarage(garage)
        case JsError(_) => BadRequest(DeserializeError(json.toString()).message)
      }
    }
  }

  def retrieveGarage(garageId: String) = Action { _ =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(_) => service.retrieveGarage(garageId)
    }
  }

  def modifyGarage(garageId: String) = Action { request =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(uuid) =>
        request.body.asJson match {
          case None => BadRequest(MissingBodyError.message)
          case Some(json) => json.validate[Garage] match {
            case JsSuccess(garage, _) => service.modifyGarage(garage.copy(id = uuid))
            case JsError(_) => BadRequest(DeserializeError(json.toString()).message)
          }
        }
    }
  }

  def deleteGarage(garageId: String) = Action { _ =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(_) => service.deleteGarage(garageId)
    }
  }

  def retrieveAllCars(garageId: String) = Action { _ =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(_) => service.retrieveAllCars(garageId)
    }
  }

  def addCarToGarage(garageId: String) = Action { request =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(uuid) =>
        request.body.asJson match {
          case None => BadRequest(MissingBodyError.message)
          case Some(json) => json.validate[Car] match {
            case JsSuccess(car, _) => service.addCarToGarage(car.copy(garageId = uuid))
            case JsError(_) => BadRequest(DeserializeError(json.toString()).message)
          }
        }
    }
  }

  def deleteAllCarsOfGarage(garageId: String) = Action { _ =>
    Try(UUID.fromString(garageId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(garageId).message)
      case Success(_) => service.deleteAllCarsOfGarage(garageId)
    }
  }

  def retrieveCarFromGarage(carId: String) = Action { _ =>
    Try(UUID.fromString(carId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(carId).message)
      case Success(_) => service.retrieveCar(carId)
    }
  }

  def modifyCarMatriculation(carId: String) = Action { request =>
    Try(UUID.fromString(carId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(carId).message)
      case Success(_) => request.body.asJson match {
        case None => BadRequest(MissingBodyError.message)
        case Some(json) => json.validate[String] match {
          case JsSuccess(matriculation, _) => service.modifyCarMatriculation(carId, matriculation)
          case JsError(_) => BadRequest(DeserializeError(json.toString()).message)
        }
      }
    }
  }

  def deleteCarFromGarage(carId: String) = Action { _ =>
    Try(UUID.fromString(carId)) match {
      case Failure(_) => BadRequest(IncorrectIdError(carId).message)
      case Success(_) => service.deleteCar(carId)
    }
  }
}
