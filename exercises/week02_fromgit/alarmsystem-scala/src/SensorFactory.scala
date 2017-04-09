import scala.collection.mutable.ListBuffer

object SensorFactory {
  def BaseSensors:ListBuffer[Sensor] = {
    val sensors = new ListBuffer[Sensor]()
    sensors += new FireSensor()
    sensors += new SmokeSensor()
    sensors
  }
}