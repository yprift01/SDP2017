abstract class AbstractSensor(triggerRate:Int, batteryRate:Int) extends HazardSensor {

  var batteryLife:Int = 100

  abstract def isTriggered: Boolean = {
    batteryLife -= batteryRate
    if(batteryLife <= 0) {
      batteryLife = 0
      throw new Exceptin("Out of Battery!")
    }
    val rand = new scala.util.Random
    val trg = rand.nextInt(100)
    trg <= triggerRate
  }

  abstract def getLocation: String = null

  abstract def getSensorType: String = null

  abstract def getBatteryPercentage: Double = -1
}
