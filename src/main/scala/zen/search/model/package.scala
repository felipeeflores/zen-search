package zen.search

package object model {
  type ErrorOr[A] = Either[AppError, A]
}
