package bc

import vm.VirtualMachine

/**[[ByteCodeWithName]] trait extends [[ByteCode]] to add a
  * 'name' field to all classes implementing the trait.
  *
  */
trait ByteCodeWithName extends ByteCode {
  val name: String
}
/**[[IConst]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  * @param arg integer value
  *
  */

class IConst(val arg: Int) extends ByteCodeWithName {
  val name: String = "iconst"
  val code: Byte = bytecode(name)

  /** Takes a the val 'arg' and pushes it to the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the virtual machine object
    *
    */
  def execute(vm: VirtualMachine): VirtualMachine =  {
    vm.push(arg)
    vm
  }
}

/**[[IAdd]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IAdd extends ByteCodeWithName {

  val name: String = "iadd"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack,
    * adds them together and pushes the result to the top of the
    * VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {

    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1+i2)
    vm
      }

}

/**[[ISub]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */
class ISub extends ByteCodeWithName {

  val name: String = "isub"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack,
    * subtracts the second value from the first, and pushes
    * the result to the top of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1-i2)
    vm
  }

}

/**[[IMul]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IMul extends ByteCodeWithName {

  val name: String = "imul"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack,
    * computes the product and pushes the result to the top
    * of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1*i2)
    vm
  }

}

/**[[IDiv]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IDiv extends ByteCodeWithName {

  val name: String = "idiv"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack,
    * divides the first by the second and pushes the result to the top
    * of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1/i2)
    vm
  }

}

/**[[IRem]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IRem extends ByteCodeWithName {

  val name: String = "irem"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack,
    * calculates the modulus of the first by the second and pushes
    * the result to the top of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1%i2)
    vm
  }

}

/**[[INeg]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class INeg extends ByteCodeWithName {

  val name: String = "ineg"
  val code: Byte = bytecode(name)

  /** Takes top value from VirtualMachine stack,
    * negates it and pushes the result to the top
    * of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(-i1)
    vm
  }

}

/**[[IInc]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IInc extends ByteCodeWithName {

  val name: String = "iinc"
  val code: Byte = bytecode(name)

  /** Takes top value from VirtualMachine stack,
    * increments it by one and pushes the result to the top
    * of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */


  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(i1+1)
    vm
  }

}

/**[[IDec]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IDec extends ByteCodeWithName {

  val name: String = "idec"
  val code: Byte = bytecode(name)

  /** Takes top value from VirtualMachine stack,
    * decrements it by one and pushes the result to the top
    * of the VirtualMachine object stack.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(i1-1)
    vm
  }

}

/**[[ISwap]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class ISwap extends ByteCodeWithName {

  val name: String = "iswap"
  val code: Byte = bytecode(name)

  /** Takes top two values from VirtualMachine stack and pushes
    * them back to the top of the VirtualMachine object stack
    * in the opposite order.
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()

    vm.push(i1)
    vm.push(i2)

    vm
  }

}

/**[[IDup]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */

class IDup extends ByteCodeWithName {

  val name: String = "idup"
  val code: Byte = bytecode(name)

  /** Takes top value from VirtualMachine stack and pushes
    * it top of the VirtualMachine object stack twice.
    *
    *
    * @param vm the virtual machine object
    * @return vm the updated virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()

    vm.push(i1)
    vm.push(i1)

    vm
  }

}

/**[[IPrint]] class extends [[ByteCodeWithName]] to access
  * definitions in that trait.
  *
  *
  */


class IPrint extends ByteCodeWithName {

  val name: String = "print"
  val code: Byte = bytecode(name)

  /** Takes top value from VirtualMachine stack and
    * prints it to the console.
    *
    *
    * @param vm the virtual machine object
    * @return vm the unchanged virtual machine object
    */

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    println(i1.toString)
    vm
  }

}