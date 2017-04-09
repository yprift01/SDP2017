/**
  * Created by yprift01 on 09/04/17.
  */
abstract class AbstractBaseSensor(location:String) extends Sensor {

  def getLocation: String = location

  def getSensorType: String = this.getClass().getName


}
