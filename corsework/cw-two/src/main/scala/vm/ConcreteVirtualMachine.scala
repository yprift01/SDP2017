package vm

import bc.ByteCode

import scala.collection.mutable

/**
  * Created by yprift01 on 17/04/17.
  */
class ConcreteVirtualMachine extends VirtualMachine {

  val stack:mutable.Stack[Int] = new mutable.Stack[Int]()

  override def execute(bc: Vector[ByteCode]):VirtualMachine = {
    var temp:VirtualMachine = new ConcreteVirtualMachine
      bc.foreach(code => {
        temp = code.execute(temp)
      })
    temp

  }

  override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {

    var temp:VirtualMachine = this
    if(bc.length == 0 )
       return (bc, temp)
      var list = bc.toList
      val first = list(0)
      list = list.filter(_ != first)

    temp = first.execute(temp)
    (list.toVector, temp)
  }

  override def pop():(Int, VirtualMachine) = {
    try{
      val temp:Int = stack.pop()
      val vmIns:VirtualMachine = this
      (temp, vmIns )
    } catch {
      case _: Throwable => throw new MachineUnderflowException("Pop on an empty stack")
    }
  }

  override def push(value: Int) = {
    stack.push(value)
    this
  }

  override def state = stack.toVector


}
