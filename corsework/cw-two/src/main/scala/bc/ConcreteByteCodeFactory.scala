package bc

/**
  * [[ConcreteByteCodeFactory]] is a concrete implementation of the [[ByteCodeFactory]]
  * interface for creating [[ByteCode]] objects.
  *
  */

class ConcreteByteCodeFactory extends ByteCodeFactory with ByteCodeValues {

  private val codebyte = bytecode map {_.swap}

  /**
    * Returns a [[ByteCode]].
    *
    * This method creates a new [[ByteCode]] object given the `byte`
    * that corresponds to the bytecode (see [[ByteCodeValues]]. If
    * the bytecode requires arguments then an optional integer
    * argument is provided.
    *
    * This method throws a [[InvalidBytecodeException]] if the
    * given bytecode value is unknown.
    *
    * @param byte the byte code of a bytecode
    * @param args an optional integer argument (depends on bytecode)
    * @return a new bytecode object
    */
  override def make(byte: Byte, args: Int*): ByteCode = {
    try{
    codebyte(byte) match {
      case "iconst" => new IConst(args(0))
      case "iadd" => new IAdd()
      case "isub" => new ISub()
      case "imul" => new IMul()
      case "idiv" => new IDiv()
      case "irem" => new IRem()
      case "ineg" => new INeg()
      case "iinc" => new IInc()
      case "idec" => new IDec()
      case "iswap" => new ISwap()
      case "idup" => new IDup()
      case "print" => new IPrint()
      case _ => throw new InvalidBytecodeException(byte.toString + " is not valid")
      }
    }
    catch {
      // entering a value not in the cases throws a NoSuchElementException
      // caught here to return an InvalidBytecodeException
      case ex: NoSuchElementException => throw new InvalidBytecodeException(byte.toString + " is not valid")
    }
  }

}
