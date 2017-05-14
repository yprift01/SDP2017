package decorator

class SimplyVegPizza extends Pizza {
  def getDesc: String = {
    return "Simply Veg"
  }

  def getPrice: Double = {
    return 230
  }
}
