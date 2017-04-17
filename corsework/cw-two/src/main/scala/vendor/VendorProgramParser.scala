package vendor

import scala.collection.mutable.Queue
import scala.io.BufferedSource

/**
  * Created by yprift01 on 16/04/17.
  */
class VendorProgramParser extends ProgramParser {


  override type InstructionList = Vector[Instruction]

  /**
    * Parses a file representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param file the file to parse
    * @return an instruction list
    */
  override def parse(file: String): InstructionList = {
    var stringToParse:String  = ""       //string to store the content of the file

    //This is a dependency that shouldn't be here. Need to be injected as a service.
    var src:BufferedSource  = null         //Open the file as buffered source, make sure to close when one

    try {
      src = scala.io.Source.fromFile(file) //Try to open the file into a buffered source
      stringToParse = src.mkString         //Try to read content into string
    }catch {                               //In case of failure to read content return empty instruction list and ignore error

      case ex:Exception => return  Vector.empty[Instruction]             //

    } finally {                            //Make sure to close file if it is open
      if(src!=null) src.close
    }

    if(stringToParse == null || stringToParse.length() == 0) //If string with content from file is empty return empty instruction list
      return Vector.empty[Instruction]

    parseString(stringToParse)

  }


  /**
    * Parses a string representation of a bytecode program
    * into an `InstructionList`.
    *
    * @param stringToParse the string to parse
    * @return an instruction list
    */
  def parseString(stringToParse: String): InstructionList = {
    val tempList = new Queue[Instruction]          //emtpy result
    val allLines = stringToParse.split("\\r?\\n")  // Split content into an array of strings. One item for each line. Splity by new line char both for windows or linux file types

    if (allLines == null || allLines.length ==0)   //return empty result if nothing to parse
      return tempList.toVector

    allLines.foreach(x=>{       //Foreach of the lines in the string

      //Create an instruction based on the instruction name and the parameters and add it to the queue
      tempList+= new Instruction(getInstruction(x), getParameters(x))
    })

    tempList.toVector //Return the queue as a vector
  }


  /**
    Parses a string into instructions and parameters and return only the instruction
    @param line the string represeting an entry on the instruction list
    @return returns the instruction name
  */
  private def getInstruction(line:String): String = {
    val allParams = line.split(" ")
    allParams(0)
  }

  /**
    * Returns an vector with all the parameters from an instruction line
    * @param line the string representing an entry on the instruction list
    * @return return all parameters as a vector
    */
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
