package Strategy

import java.time.LocalDateTime

/**
  * Created by yprift01 on 09/04/17.
  */
class Siren extends Strategy {

  override def triggerAction: Unit = {
    //logic for siren
    lastAction = LocalDateTime.now()
  }

  var lastAction: LocalDateTime = null
}
