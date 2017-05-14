package decorator

trait Pizza {
  def getDesc: String

  def getPrice: Double
}

abstract class BasePizza(basepizza:Pizza, price:Double, desc:String) extends Pizza{

  private val totalPrice = basepizza.getPrice + price
  private val totalDesc = basepizza.getDesc + ", " + desc + s"($price)"

  def getDesc: String = {
   totalDesc
  }

  def getPrice: Double = {
     totalPrice
  }
}