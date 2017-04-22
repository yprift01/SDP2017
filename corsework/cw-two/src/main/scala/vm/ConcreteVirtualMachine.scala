package vm

import bc.ByteCode

import scala.collection.mutable

/**
  * Created by yprift01 on 17/04/17.
  *
  * [[ConcreteVirtualMachine]] is a concrete implementation of the [[VirtualMachine]] interface.
  *
  *
  */
class ConcreteVirtualMachine extends VirtualMachine {

  val stack:mutable.Stack[Int] = new mutable.Stack[Int]()

  /**
    * Executes each command in the vector of bytecodes.
    *
    * @param bc a vector of bytecodes
    * @return a new virtual machine
    */

  override def execute(bc: Vector[ByteCode]):VirtualMachine = {
    var temp:VirtualMachine = new ConcreteVirtualMachine
      bc.foreach(code => {
        temp = code.execute(temp)
      })
    temp

  }

  /**
    * Executes only the first command in the vector of bytecodes.
    *
    * @param bc the vector of bytecodes
    * @return a tuple of a new vector of bytecodes and virtual machine
    */

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

  /**
    * Retrieves the top value from the virtual machine stack.
    *
    * @return (i, vm), where i is the integer popped and vm is the
    *         new virtual machine
    */

  override def pop():(Int, VirtualMachine) = {
    try{
      val temp:Int = stack.pop()
      val vmIns:VirtualMachine = this
      (temp, vmIns )
    } catch {
      case _: Throwable => throw new MachineUnderflowException("Pop on an empty stack")
    }
  }

  /**
    * Pushes an Integer value to the top of the virtual machine stack.
    *
    * @param value the integer to push
    * @return a new virtual machine with the integer `value` pushed
    */

  override def push(value: Int) = {
    stack.push(value)
    this
  }

  /**
    * Returns the current state of the virtual machine stack as a vector.
    *
    * @return the state of the stack
    */

  override def state = stack.toVector


}
