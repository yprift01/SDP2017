package Strategy

import java.time.LocalDateTime

/**
  * Created by yprift01 on 09/04/17.
  */
class Call(phoneNumber: String) extends Strategy {

  var lastAction:java.time.LocalDateTime = null

  override def triggerAction = {
    //trigger logic
    lastAction = LocalDateTime.now()  // Calendar.getInstance()
  }

}
