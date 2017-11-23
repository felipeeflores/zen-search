package zen.search.effects

import org.specs2.mutable.Specification
import zen.search.model.AppError
import zen.search.model.AppError.LoadResourceError

import scala.util.Random

class AppInterpreterSpec extends Specification {

  val appInterpreter = new AppInterpreter()

  "AppInterpreter" should {

    "execute a LoadResourceAction" should {

      "return an error for non-existent file" in {
        val randomFileName = Random.nextString(10)
        val action = AppAction.loadResourceAction(randomFileName)

        appInterpreter.run(action) must beLeft[AppError](LoadResourceError(s"Failed to load resource $randomFileName"))
      }

      "return the file content as a String" in {
        val action = AppAction.loadResourceAction(getClass.getResource("/test.resource").getPath)

        appInterpreter.run(action) must beRight("zen-search")
      }
    }
  }
}
