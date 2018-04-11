package model

import java.time.LocalDateTime
import java.util.UUID

import play.api.libs.json._

case class Garage(id: UUID,
                  name: String,
                  address: String,
                  creationDate: LocalDateTime,
                  maximumCapacity: Int)

object Garage {

  implicit val garageFormats = Json.format[Garage]

  def writeGarage(address: Garage) = {
    Json.toJson(address)
  }

  def readGarage(jsonGarage: JsValue) = {
    val name = (jsonGarage \ "name").as[String]
    val address = (jsonGarage \ "address").as[String]
    val maximumCapacity = (jsonGarage \ "maximumCapacity").as[Int]

    Garage(
      UUID.randomUUID(),
      name,
      address,
      LocalDateTime.now(),
      maximumCapacity
    )
  }
}
