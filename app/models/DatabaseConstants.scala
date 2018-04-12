package models

object DatabaseConstants {

  val CREATE_GARAGE = "INSERT INTO garages (id, name, address, creation_date, maximum_capacity) VALUES(?,?,?,?,?)"
  val RETRIEVE_GARAGE = "SELECT * FROM garages WHERE id = ?"
  val UPDATE_GARAGE = "UPDATE garages SET name = ?, address = ?, maximum_capacity = ? WHERE id = ?"
  val DELETE_GARAGE = "DELETE FROM garages WHERE id = ?; DELETE FROM cars WHERE garage_id = ?"

  val RETRIEVE_ALL_CARS_FROM_GARAGE = "SELECT * FROM cars WHERE garage_id = ?"
  val CREATE_CAR_IN_GARAGE = "INSERT INTO cars (id, matriculation, brand, model, color, commissioning_date, price, garage_id) VALUES(?,?,?,?,?,?,?,?)"
  val DELETE_ALL_CARS_OF_GARAGE = "DELETE FROM cars WHERE garage_id = ?"
  val RETRIEVE_CAR = "SELECT * FROM cars WHERE id = ?"
  val UPDATE_CAR_MATRICULATION = "UPDATE cars SET matriculation = ? WHERE id = ?"
  val DELETE_CAR = "DELETE FROM cars WHERE id = ?"

  val RETRIEVE_GARAGE_CAPACITY = "SELECT count(*) FROM cars WHERE garage_id = ?"
}
