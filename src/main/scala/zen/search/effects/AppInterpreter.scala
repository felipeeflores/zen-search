package zen.search.effects

import cats.{Id, Monad}
import zen.search.effects.AppAction.LoadResourceAction
import zen.search.model.AppError.LoadResourceError

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Simple interpreter for the application.
  *
  * We use the Id monad here for simplicity. In a production application this would have to be updated/replaced
  * with an interpreter ready for async processing with something like a Monix Task, Scala Future (not so recommended)
  * or equivalent.
  */
class AppInterpreter extends Interpreter[Id] {

  val monad = implicitly[Monad[Id]]

  override def apply[A](fa: AppAction[A]): Id[A] = fa match {

    case LoadResourceAction(path) => loadFileToString(path)
  }

  private def loadFileToString(fileName: String) = monad.pure {
    Try(Source.fromFile(fileName).mkString) match {
      case Success(fileContent) =>
        Right(fileContent)
      case Failure(_) =>
        Left(LoadResourceError(s"Failed to load resource $fileName"))
    }
  }
}