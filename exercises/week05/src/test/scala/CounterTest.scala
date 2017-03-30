
package week05

import org.scalatest.FunSuite

class CounterTests extends FunSuite {
  // Basics
  test("test new Counter return value") {
    assert(new Counter(10).count == 10)
  }
  test("test some increments with and without value") {
    val origin = new Counter(10)
    assert(origin.inc().inc().inc(3).count == 15)
    assert (origin.count == 10)
  }
  test("test some decrement with and without value") {
    assert(new Counter(10).dec().dec().dec(3).count == 5)
  }
  test("test mixed with and without value") {
    assert(new Counter(10).inc(20).dec().dec().inc().dec(3).count == 26)
  }
  test("Adjust adds adder value") {
    assert(new Counter(10).adjust(new Adder(10)).count == 20)
  }
}