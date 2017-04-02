package factory

/**
  * Created by yprift01 on 02/04/17.
  */
abstract class Creator {
  def factory:Product = {
    new ConcreteProduct()
  }

}
