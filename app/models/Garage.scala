package models

import java.time.LocalDateTime
import java.util.UUID

import play.api.libs.json._

import scala.util.Try

case class Garage(id: UUID,
                  name: String,
                  address: String,
                  creationDate: LocalDateTime,
                  maximumCapacity: Int)

object Garage {

  implicit val garageFormats = Json.format[Garage]

  def readGarage(jsonGarage: JsValue): Try[Garage] = {
    Try {
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
}
