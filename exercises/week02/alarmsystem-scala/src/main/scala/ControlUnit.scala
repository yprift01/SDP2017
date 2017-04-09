import Strategy.StrategyClient

import scala.collection.mutable.ListBuffer

class ControlUnit(sensors: ListBuffer[Sensor], strategyRunners: ListBuffer[StrategyClient] ) {
  def pollSensors() {
    for (sensor <- sensors) {
      if (sensor.isTriggered) {
        strategyRunners.foreach(x=>x.triggerAction)
        System.out.println("A " + sensor.getSensorType + " sensor was triggered at " + sensor.getLocation)
      }
      else {
        System.out.println("Polled " + sensor.getSensorType + " at " + sensor.getLocation + " successfully")
      }
    }
  }
}

object ControlUnit
