package factory

import bc.{ByteCodeFactory, ByteCodeParser}
import vendor.{ProgramParser, VendorProgramParser}
import vm.{VirtualMachine, VirtualMachineParser}
import bc.{ConcreteByteCodeFactory, ConcreteByteCodeParser}

/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods for each of the important parts in this assignment. You must
  * implement each method such that it returns an object of the correct type.
  */
object VirtualMachineFactory {
  // TODO
  def byteCodeFactory: ByteCodeFactory = new ConcreteByteCodeFactory

  // TODO
  def vendorParser: ProgramParser = new VendorProgramParser

  // TODO
  def byteCodeParser: ByteCodeParser = new ConcreteByteCodeParser(byteCodeFactory)

  // TODO
  def virtualMachineParser: VirtualMachineParser = ???

  // TODO
  def virtualMachine: VirtualMachine = ???
}
