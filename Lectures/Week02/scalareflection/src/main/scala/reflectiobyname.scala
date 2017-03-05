package week02

import scala.reflect.runtime.universe._
import scala.io.StdIn._

trait A
trait B extends A
trait C extends B with A
case class reflectionbyname() extends C {

  def getTypeByName(name: String): Class[_] = {
    try {
      val obj = Class.forName(name)
      obj
    }catch {
      case _ => throw new ClassNotFoundException
    }

  }

  def getType[T: TypeTag](obj: T) = typeOf[T]

  def getInterface(tp: Class[_]): String = {
    val interface = tp.getInterfaces
    val baseclass = tp.getSuperclass

    val rest = interface map(x=>x.getName)
    val printrest = rest.mkString(", ")

    println(s"Interfaces: $printrest")
    println(baseclass)

    rest + baseclass.toString()

  }

}
object mainObject {

  def main(args: Array[String]){
    println("Enter class name: ")
    val className = readLine()

    val ref=reflectionbyname()

    try {
      val tp = ref.getTypeByName(className)
      ref.getInterface(tp)
    }catch{
      case _ => println("Class Not Found")
    }


  }

}
