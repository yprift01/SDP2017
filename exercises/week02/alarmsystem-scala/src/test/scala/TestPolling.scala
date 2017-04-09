import org.scalatest.FunSuite

/**
  * Created by yprift01 on 09/04/17.
  */
class TestPolling extends FunSuite {

   test("Base polling if sensor is triggered then Strategy has been called"){
     val sensors = SensorFactory.BaseSensors
     val runners = StrategyFactory.BaseStrategy
     val cu = new ControlUnit(sensors, runners)
     cu.pollSensors()
     var wasTriggered = false
     sensors.foreach(x=>if(x.wasTriggered) wasTriggered=true )
     if(wasTriggered)
       runners.foreach(x=>assert(x.lastAction != null))
     else
     runners.foreach(x=>assert(x.lastAction == null))
   }

  test("When out of battery throws exception") {
    val sensors = SensorFactory.BaseSensors
    val runners = StrategyFactory.BaseStrategy
    val cu = new ControlUnit(sensors, runners)

    val thrown = intercept[OutOfBatteryException]{
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()
      cu.pollSensors()

    }
    assert(thrown.getMessage() === "Out of Battery!")
  }

  test("When running sufficiently long sensor should trigger"){
    var sensors = SensorFactory.BaseSensors
    var runners = StrategyFactory.BaseStrategy
    var cu = new ControlUnit(sensors, runners)
    cu.pollSensors()
    while(sensors.forall(x=>x.wasTriggered==false))
      {
        //reset to restart battery at 100%
         sensors = SensorFactory.BaseSensors
         runners = StrategyFactory.BaseStrategy
         cu = new ControlUnit(sensors, runners)
        cu.pollSensors()
      }
  }

  test("Security sensor should trigger when running 24hrs"){
    val securitySensors = SensorFactory.SecuritySensors
    val runners = StrategyFactory.BaseStrategy
    val cu = new SecurityControlUnit(0, 0, securitySensors, runners)

    while(securitySensors.count(x=>x.wasTriggered) == 0) {
      cu.pollSensors()
    }

  }

}

