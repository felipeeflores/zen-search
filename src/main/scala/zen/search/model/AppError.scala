package zen.search.model

sealed trait AppError {
  val message: String
}

object AppError {
  case class LoadResourceError(message: String) extends AppError
}
