package models

import java.time.LocalDate
import java.util.UUID

import play.api.libs.json._

import scala.util.Try


case class Car(id: UUID,
               matriculation: String,
               brand: String,
               model: String,
               color: String,
               commissioningDate: LocalDate,
               price: Double,
               garageId: UUID)

object Car {

  implicit val carFormats = Json.format[Car]

  def readCar(jsonCar: JsValue): Try[Car] = {
    Try {
      val matriculation = (jsonCar \ "matriculation").as[String]
      val brand = (jsonCar \ "brand").as[String]
      val model = (jsonCar \ "model").as[String]
      val color = (jsonCar \ "color").as[String]
      val commissioningDate = LocalDate.parse((jsonCar \ "commissioningDate").as[String])
      val price = (jsonCar \ "price").as[Double]

      Car(
        UUID.randomUUID(),
        matriculation,
        brand,
        model,
        color,
        commissioningDate,
        price,
        UUID.randomUUID()
      )
    }
  }
}
