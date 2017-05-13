package factory

/**
  * Created by yprift01 on 22/04/17.
  */
abstract class Creator {

  def factory: Product = {
      new ConcreteProduct()
  }
}

class ConcreteCreator extends Creator {
  override def factory:Product = {
    new ConcreteProduct
  }
}