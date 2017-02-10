package Lecture05

import lect05._

class lect05Test extends org.scalatest.FunSuite {
  test("Interesecting Points")  {
    assert(inter(1,2,3,4) == SomePoint(Point(-1.0,1.0)))
  }
  test("Parallel Point") {
    assert(inter(1,2,1,2) == NoPoint())
  }
}