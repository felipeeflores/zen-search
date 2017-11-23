package zen.search.effects

import cats.free.Free
import zen.search.model.ErrorOr

sealed trait AppAction[A] {
  def lift: Program[A] = Free.liftF(this)
}

object AppAction {

  case class LoadResourceAction(path: String) extends  AppAction[ErrorOr[String]]

  def loadResourceAction(path: String) = LoadResourceAction(path).lift
}