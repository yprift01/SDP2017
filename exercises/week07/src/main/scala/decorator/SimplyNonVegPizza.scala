package decorator

class SimplyNonVegPizza extends Pizza {

  def getDesc: String = {
    return "Simply Non Veg"
  }

  def getPrice: Double = {
    return 350
  }
}
