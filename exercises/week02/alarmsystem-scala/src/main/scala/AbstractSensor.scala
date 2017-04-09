abstract class AbstractSensor(triggerRate:Int, batteryRate:Int, location:String)
  extends AbstractBaseSensor(location)
    with HazardSensor {

  var wasTriggered:Boolean = false
  var batteryLife:Int = 100
  def getBatteryPercentage: Double = batteryLife

  def isTriggered: Boolean = {
    batteryLife -= batteryRate
    if(batteryLife <= 0) {
      batteryLife = 0
      throw new OutOfBatteryException()
    }
    val rand = new scala.util.Random
    val trg = rand.nextInt(100)
    wasTriggered = trg <= triggerRate
    wasTriggered
  }

}

class OutOfBatteryException extends Exception("Out of Battery!")