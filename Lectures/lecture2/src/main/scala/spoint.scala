class SPoint(var x: Double, var y: Double) {
  def magnitude(pt: SPoint): Double = {
    math.sqrt(pt.x * pt.x + pt.y * pt.y)
  }
}