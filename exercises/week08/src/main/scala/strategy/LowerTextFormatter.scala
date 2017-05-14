package strategy

//TODO
case class LowerTextFormatter() extends TextFormatter {
  override def format(text: String): Unit = println("LowerTextFormater]:"+text toLowerCase)
}
