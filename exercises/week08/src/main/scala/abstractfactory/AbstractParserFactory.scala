package abstractfactory

trait AbstractParserFactory {
  def getParserInstance(parserType: String): XMLParser
}

class NycFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String) = {
    parserType match {
      case "NYCORDER" => new NycOrder()
      case _ => throw new ParserNotImplementedError()
    }
  }
}

class LondonFactory extends AbstractParserFactory {
  override def getParserInstance(parserType: String) = {
    parserType match {
      case "LondonFEEDBACK" => new LondonFeedback()
      case _ => throw  new ParserNotImplementedError()
    }
  }
}

class ParserNotImplementedError() extends Exception("Parser not yet implemented"){}