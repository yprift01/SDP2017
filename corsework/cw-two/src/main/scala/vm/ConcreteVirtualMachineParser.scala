package vm

import vendor.Instruction
import bc.{ByteCode, ByteCodeFactory, ByteCodeValues, InvalidBytecodeException}
import vendor.{ProgramParser, InvalidInstructionFormatException}

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.io.BufferedSource

/**
  * Created by yprift01 on 17/04/17.
  */
class ConcreteVirtualMachineParser
      (val bc: ByteCodeFactory, val parser: ProgramParser)
      extends VirtualMachineParser
      with ByteCodeValues
 {

   //private val codebyte = bytecode map {_.swap}

  override def parse(file: String): Vector[ByteCode] = {
     convert(parser.parse(file));

  }


  def parseString(stringToParse: String): Vector[ByteCode] = {
    convert(parser.parseString(stringToParse))
  }

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

   private def bc(name:String): Byte = {
     try {
       bytecode(name)
     }catch {
       case ex: NoSuchElementException => throw new  InvalidBytecodeException(name + " Instruction does not exist ")
     }
   }

}
