/**
  * Created by yprift01 on 30/03/17.
  */
package week05
case class Person(var firstName:String, var lastName:String) {

}

object Person{
  def apply(fullName:String): Person = {
    val both = fullName.split(" ")
    val firstName = both(0)
    val lastName = both(1)
    new Person(firstName, lastName)
  }
}