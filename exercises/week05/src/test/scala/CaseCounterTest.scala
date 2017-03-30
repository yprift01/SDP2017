
package week05

import org.scalatest.FunSuite


class CaseCounterTests extends FunSuite {
  // Basics
  test("test new Counter return value") {
    val c1 = CaseCounter(20)
    val c2 = CaseCounter(10)
    c1.inc()
    assert(c2.count == 10)
  }
  test("test some increments with and without value") {
    val origin = CaseCounter(10)
    assert(origin.inc().inc().inc(3).count == 15)
    assert(origin.count==10)
    var person = Person.apply("Jon Doe")
  }
  test("test some decrement with and without value") {
    assert(CaseCounter(10).dec().dec().dec(3).count == 5)
  }
  test("test mixed with and without value") {
    assert(CaseCounter(10).inc(20).dec().dec().inc().dec(3).count == 26)
  }

  test("Adjust adds adder value") {
    assert(CaseCounter(10).adjust(new Adder(10)).count == 20)
  }
}