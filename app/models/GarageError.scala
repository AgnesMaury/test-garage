package models

sealed trait GarageError {
  val message: String
}

case object MissingBodyError extends GarageError {
  override val message: String = "No body has been found"
}

case class IncorrectIdError(value: String) extends GarageError {
  override val message: String = s"Value $value is not a valid uuid"
}

case class DeserializeError(t: Throwable) extends GarageError {
  override val message: String = s"Cannot deserialize json : ${t.getMessage}"
}
