package factory

/**
  * Created by yprift01 on 02/04/17.
  */
class ConcreteCreator extends Creator{
  override def factory:Product = {
    new ConcreteProduct()
  }
}
