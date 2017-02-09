package sml
import scala.reflect.runtime.{universe => ru}
import scala.util.Try
/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val LIN = "lin"
  private final val BNZ = "bnz"
  private final val MUL = "mul"
  private final val SUB = "sub"
  private final val OUT = "out"

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    import scala.io.Source
    val lines = Source.fromFile(fileName).getLines
    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))
        val clsName:String = "sml." + fields(1).capitalize + "Instruction"
        val mirror = ru.runtimeMirror(getClass.getClassLoader)
        val cls = mirror.classSymbol(Class.forName(clsName))
        val module = cls.companion.asModule
        val ctor = Class.forName(clsName).getConstructors()(0);
        //val instance = mirror.reflectModule(module).instance
        val params = fields.map(x=>Try(x.toInt).getOrElse(x))
        val instance = ctor.newInstance(params).asInstanceOf[Instruction]
        program:+ instance

        /*

        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }
        */
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) = new Translator(file)
}
