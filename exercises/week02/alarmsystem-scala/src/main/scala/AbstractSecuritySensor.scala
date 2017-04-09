/**
  * Created by yprift01 on 09/04/17.
  */
abstract class AbstractSecuritySensor(triggerRate:Int, location:String)
  extends AbstractBaseSensor(location)
  with SecuritySensor{

  var wasTriggered:Boolean = false

  override def isTriggered: Boolean = {
    val rand = new scala.util.Random
    val trg = rand.nextInt(100)
    wasTriggered = trg <= triggerRate
    wasTriggered
  }

}
