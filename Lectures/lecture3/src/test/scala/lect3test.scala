package lect3

import Lecture3._

class Lect3Test extends org.scalatest.FunSuite {
  test("Call ilength with anytype") {
    assert(ilenght(5::"3"::1::Nil)==3)
  }

}