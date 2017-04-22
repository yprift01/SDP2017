package factory

import bc.{ByteCodeFactory, ByteCodeParser, ConcreteByteCodeFactory, ConcreteByteCodeParser}
import vendor.{ProgramParser, VendorProgramParser}
import vm.{ConcreteVirtualMachine, ConcreteVirtualMachineParser, VirtualMachine, VirtualMachineParser}


/**
  * The `VirtualMachineFactory` follows the *factory pattern*. It provides
  * methods that each return an object of the correct type to construct a new
  * VirtualMachine.
  */
object VirtualMachineFactory {

  def byteCodeFactory: ByteCodeFactory = new ConcreteByteCodeFactory


  def vendorParser: ProgramParser = new VendorProgramParser


  def byteCodeParser: ByteCodeParser = new ConcreteByteCodeParser(byteCodeFactory)


  def virtualMachineParser: VirtualMachineParser = new ConcreteVirtualMachineParser(byteCodeFactory, vendorParser)


  def virtualMachine: VirtualMachine = new ConcreteVirtualMachine
}
