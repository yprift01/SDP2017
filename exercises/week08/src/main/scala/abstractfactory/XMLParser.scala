package abstractfactory

trait XMLParser {
  def parse():String

  // TODO
}

class NycOrder extends XMLParser {
  println("NYC Parsing order XML...")
  def parse = "NYC Order XML Message"
}

class LondonFeedback extends XMLParser {
  println("London Parsing feedback XML...")
  def parse = "London Feedback XML Message"
}