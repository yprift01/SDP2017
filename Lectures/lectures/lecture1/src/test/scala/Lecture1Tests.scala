import Lecture1._
import org.scalatest._
class Lecture1Tests extends org.scalatest.FunSuite {
  test ("fac -- base case") {
		assert(fac(0) == 1)
	}

  test ("fac -- inductive test") {
		assert(fac(5) == 120)
	}
}
