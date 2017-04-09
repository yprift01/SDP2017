import scala.collection.mutable.ListBuffer
import java.util.Calendar


class SecurityControlUnit( var startRunningTime:Int = 22,
                           var endRunningTime:Int = 6,
                           sensors: ListBuffer[SecuritySensor],
                           runner:ListBuffer[Strategy.StrategyClient])
  extends ControlUnit(sensors.asInstanceOf[ListBuffer[Sensor]], runner){

  val START_TIME: Int = startRunningTime
  val END_TIME: Int = endRunningTime


  def timecheck:Boolean = {
    val now = Calendar.getInstance().get(Calendar.HOUR)
    now >=START_TIME || END_TIME >= now
  }

  override def pollSensors(): Unit = {
    if (timecheck)
      super.pollSensors()
  }

}
