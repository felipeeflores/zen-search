package zen.search.effects

import cats.{Monad, ~>}

/**
  * Abstract class to represent any Interpreter/compiler for a Free program/script
  *
  * Note: abstract class as we need a `type parameter` with `context bounds`
  *
  * More about Free, see https://typelevel.org/cats/datatypes/freemonad.html
  *
  * @tparam M our program must be based/return a monadic type
  */
abstract class Interpreter[M[_]: Monad] extends (AppAction ~> M) {
  def run[A](program: Program[A]): M[A] = program.foldMap(this)
}
