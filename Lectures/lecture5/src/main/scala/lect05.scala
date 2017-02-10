package Lecture05

case class Point(x: Double, y: Double)
sealed trait OptionalPoint
case class SomePoint(pt: Point) extends OptionalPoint
case class NoPoint() extends OptionalPoint

object lect05 {
  def inter(m1: Double, b1: Double, m2: Double, b2: Double): OptionalPoint = {
    if (m1 - m2 == 0) {
      NoPoint()
    } else {
      val x = (m1 - m2) / (b2 - b1)
      SomePoint(Point(x, m1 * x + b1))
    }
  }
}