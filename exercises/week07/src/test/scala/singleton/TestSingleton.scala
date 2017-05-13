package singleton

import org.scalatest.FunSuite

/**
  * Created by yprift01 on 22/04/17.
  */
class TestSingleton extends FunSuite{

  test("Eager Singleton Testing instances") {
    val s1 = SingletonEager.instance()
    val s2 = SingletonEager.instance()
    assert(s1==s2, "Instances should be equal")
    val s3 = SingletonEager
    assert(s3.instance()==s1, "Again the instance should be the same")

  }

  test("Eager Singleton not allowing object init ") {
    assert(true) //Error at compile time, You cannot create instance of SingletonEager
    //val s1 = new SingletonEager()
  }


  test("Lazy Singleton Testing instances") {
    val s1 = SingletonLazy.instance()
    val s2 = SingletonLazy.instance()
    assert(s1==s2, "Instances should be equal")
    val s3 = SingletonLazy
    assert(s3.instance()==s1, "Again the instance should be the same")

  }

  test("Protected Singleton Testing instances protecred aginst clone and multithread") {
    val s1 = SingletonProtectedScala.instance()
    val s2 = SingletonProtectedScala.instance()
    assert(s1==s2, "Instances should be equal")
    val s3 = SingletonProtectedScala
    assert(s3.instance()==s1, "Again the instance should be the same")
  }

}
