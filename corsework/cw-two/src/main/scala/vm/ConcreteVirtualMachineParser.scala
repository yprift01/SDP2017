package vm

import vendor.Instruction
import bc.{ByteCode, ByteCodeFactory, ByteCodeValues, InvalidBytecodeException}
import vendor.{ProgramParser, InvalidInstructionFormatException}

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.io.BufferedSource

/**
  * Created by yprift01 on 17/04/17.
  *
  * [[ConcreteVirtualMachineParser]] is a concrete implementation of the [[VirtualMachineParser]].
  * It defines all of the definitions required to parse in instructions for execution
  * by the virtual machine.
  *
  */
class ConcreteVirtualMachineParser
      (val bc: ByteCodeFactory, val parser: ProgramParser)
      extends VirtualMachineParser
      with ByteCodeValues
 {

   //private val codebyte = bytecode map {_.swap}

   /**
     * Converts a list of instructions in the input file into a
     * vector of bytecode objects which can be executed by the virtual machine.
     *
     * @param file the file containing a program
     * @return a vector of bytecodes
     */

  override def parse(file: String): Vector[ByteCode] = {
     convert(parser.parse(file));

  }

   /**
     * Converts a list of instructions in a string into
     * a vector of bytecode objects which can be executed by the
     * virtual machine.
     *
     * @param stringToParse the string to convert
     * @return a vector of bytecodes
     */


  def parseString(stringToParse: String): Vector[ByteCode] = {
    convert(parser.parseString(stringToParse))
  }

   /**
     * Converts a vector of Instruction objects into a vector of
     * Bytecode objects.
     *
     * @param inList a vector of instruction objects
     * @return a vector of bytecode objects
     */

  private def convert(inList: Vector[Instruction]): Vector[ByteCode] = {
    val result = new mutable.Queue[ByteCode]()
    inList.foreach(instruction => {
      try {
        if (instruction.args.length > 0)
          result += bc.make(bc(instruction.name), instruction.args(0))
        else result += bc.make(bc(instruction.name))
      } catch {
        case ex:InvalidInstructionFormatException => throw ex
      }
    })
    result.toVector
  }

   /**
     * Retrieves the corresponding byte for a given instruction name (string). If
     * there is no corresponding byte, throws an [[InvalidBytecodeException]].
     *
     * @param name
     * @return
     */
   private def bc(name:String): Byte = {
     try {
       bytecode(name)
     }catch {
       case ex: NoSuchElementException => throw new  InvalidBytecodeException(name + " Instruction does not exist ")
     }
   }

}
