package bc

import scala.collection.mutable

class ConcreteByteCodeParser(val bcf:ByteCodeFactory) extends ByteCodeParser with ByteCodeValues {


  private val codebyte = bytecode map {_.swap}

  override def parse(bc: Vector[Byte]):Vector[ByteCode] = {
    val q = new mutable.Queue[ByteCode]()
    var i = 0;

    while(i<bc.length){
      val currentbyte = bc(i)
      var nextbyte = 0;
      if (i+1 < bc.length)
        nextbyte = bc(i+1)
      if (codebyte(currentbyte) == "iconst")
        {
          q+=bcf.make(currentbyte, nextbyte)
          i+=1
        } else q+=bcf.make(currentbyte)
      i+=1
    }

    q.toVector
  }

}
