package zen.search

import cats.free.Free

package object effects {

  type Program[A] = Free[AppAction, A]

}
