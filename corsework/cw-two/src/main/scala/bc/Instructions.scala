package bc

import vm.VirtualMachine

trait ByteCodeWithName extends ByteCode {
  val name: String
}


class IConst(val arg: Int) extends ByteCodeWithName {
  val name: String = "iconst"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    vm.push(arg)
    vm
  }
}

class IAdd extends ByteCodeWithName {

  val name: String = "iadd"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {

    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1+i2)
    vm
      }

}

class ISub extends ByteCodeWithName {

  val name: String = "isub"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1-i2)
    vm
  }

}

class IMul extends ByteCodeWithName {

  val name: String = "imul"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1*i2)
    vm
  }

}

class IDiv extends ByteCodeWithName {

  val name: String = "idiv"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1/i2)
    vm
  }

}


class IRem extends ByteCodeWithName {

  val name: String = "irem"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()
    vm.push(i1%i2)
    vm
  }

}



class INeg extends ByteCodeWithName {

  val name: String = "ineg"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(-i1)
    vm
  }

}


class IInc extends ByteCodeWithName {

  val name: String = "iinc"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(i1+1)
    vm
  }

}

class IDec extends ByteCodeWithName {

  val name: String = "idec"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    vm.push(i1-1)
    vm
  }

}

class ISwap extends ByteCodeWithName {

  val name: String = "iswap"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    val (i2, _) = vm.pop()

    vm.push(i1)
    vm.push(i2)

    vm
  }

}


class IDup extends ByteCodeWithName {

  val name: String = "idup"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()

    vm.push(i1)
    vm.push(i1)

    vm
  }

}


class IPrint extends ByteCodeWithName {

  val name: String = "print"
  val code: Byte = bytecode(name)

  def execute(vm: VirtualMachine): VirtualMachine =  {
    val (i1, _) = vm.pop()
    println(i1.toString)
    vm
  }

}