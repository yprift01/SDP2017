trait Sensor {

  def wasTriggered:Boolean

  def isTriggered: Boolean

  def getLocation: String

  def getSensorType: String
}
