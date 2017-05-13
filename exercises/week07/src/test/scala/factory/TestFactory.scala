package factory

//import factory.{ConcreteCreator, ConcreteProduct, Creator, Product}
import org.scalatest.FunSuite
/**
  * Created by yprift01 on 22/04/17.
  */
class TestFactory extends FunSuite {

  test("Creator Factory return instance of Product"){
    val product = new ConcreteCreator().factory
    assert(product.isInstanceOf[Product])
  }

}
