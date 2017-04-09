import scala.collection.mutable.ListBuffer

class ControlUnit(sensors: ListBuffer[Sensor]) {
  def pollSensors() {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

object ControlUnit
