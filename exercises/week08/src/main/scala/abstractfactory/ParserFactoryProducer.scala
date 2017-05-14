package abstractfactory

object ParserFactoryProducer {
  def getFactory(s: String) = s match {
    case "NYCFactory" => new NycFactory()
    case "LondonFactory" => new LondonFactory()
    case _ => throw new ParserNotImplementedError()
  }

  // TODO

}
