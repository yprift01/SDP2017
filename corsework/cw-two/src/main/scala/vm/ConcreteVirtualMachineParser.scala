package vm

import vendor.Instruction
import bc.{ByteCode, ByteCodeFactory, ByteCodeValues, InvalidBytecodeException}

import scala.collection.mutable.Queue
import scala.io.BufferedSource

/**
  * Created by yprift01 on 17/04/17.
  */
class ConcreteVirtualMachineParser(val bc: ByteCodeFactory)
  extends VirtualMachineParser
   with ByteCodeValues
 {

   //private val codebyte = bytecode map {_.swap}

  override def parse(file: String): Vector[ByteCode] = {
    var stringToParse:String  = ""       //string to store the content of the file

    //This is a dependency that shouldn't be here. Need to be injected as a service.
    var src:BufferedSource  = null         //Open the file as buffered source, make sure to close when one

    try {
      src = scala.io.Source.fromFile(file) //Try to open the file into a buffered source
      stringToParse = src.mkString         //Try to read content into string
    }catch {                               //In case of failure to read content return empty instruction list and ignore error

      case ex:Exception => return  Vector.empty[ByteCode]             //

    } finally {                            //Make sure to close file if it is open
      if(src!=null) src.close
    }

    if(stringToParse == null || stringToParse.length() == 0) //If string with content from file is empty return empty instruction list
      return Vector.empty[ByteCode]

    parseString(stringToParse)

  }


  def parseString(stringToParse: String): Vector[ByteCode] = {
    val tempList = new Queue[ByteCode]          //emtpy result
    val allLines = stringToParse.split("\\r?\\n")  // Split content into an array of strings. One item for each line. Splity by new line char both for windows or linux file types

    if (allLines == null || allLines.length ==0)   //return empty result if nothing to parse
      return tempList.toVector

    allLines.foreach(x=>{       //Foreach of the lines in the string

      //Create an instruction based on the instruction name and the parameters and add it to the queue
      val instr = getInstruction(x)
      val params = getParameters(x)
      try {
        if (params.length > 0)
          tempList += bc.make(bytecode(instr), params(0))
        else tempList += bc.make(bytecode(instr))
      }catch {
        case ex: NoSuchElementException => throw new InvalidBytecodeException(instr.toString + " bytecode does not exist")
      }

    })

    tempList.toVector //Return the queue as a vector
  }

  private def getInstruction(line:String): String = {
    val allParams = line.split(" ")
    allParams(0)
  }

  private def getParameters(line:String): Vector[Int] = {
    var allParams = line.split(" ")
    if(allParams.length > 1)
    {
      allParams = allParams.filterNot(_==allParams(0))
      val result = new Queue[Int]()
      allParams.foreach(p=>{
        result+=p.toInt
      })
      return result.toVector
    }
    return Vector.empty[Int]
  }

}
