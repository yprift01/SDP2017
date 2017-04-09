import scala.collection.mutable.ListBuffer

object SensorFactory {
  def BaseSensors:ListBuffer[Sensor] = {
    val sensors = new ListBuffer[Sensor]()
    sensors += new FireSensor("London")
    sensors += new SmokeSensor("Paris")
    sensors
  }

  def SecuritySensors: ListBuffer[SecuritySensor] = {
    val sensors = new ListBuffer[SecuritySensor]()
    sensors += new MotionSensor("New York")
    sensors += new MotionSensor("Las Vegas")
    sensors += new MotionSensor("Stockholm")
  }

}