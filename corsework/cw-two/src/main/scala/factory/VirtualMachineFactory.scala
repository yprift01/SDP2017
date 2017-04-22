package factory

import bc.{ByteCodeFactory, ByteCodeParser, ConcreteByteCodeFactory, ConcreteByteCodeParser}
import vendor.{ProgramParser, VendorProgramParser}
import vm.{ConcreteVirtualMachine, ConcreteVirtualMachineParser, VirtualMachine, VirtualMachineParser}


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
  def virtualMachineParser: VirtualMachineParser = new ConcreteVirtualMachineParser(byteCodeFactory, vendorParser)

  // TODO
  def virtualMachine: VirtualMachine = new ConcreteVirtualMachine
}
