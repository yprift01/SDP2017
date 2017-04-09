package Strategy

import java.time.LocalDateTime

/**
  * Created by yprift01 on 09/04/17.
  */
trait StrategyClient{
      def strategy:Strategy
      def lastAction:LocalDateTime
      def triggerAction:Unit
}
