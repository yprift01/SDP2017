package Strategy

/**
  * Created by yprift01 on 09/04/17.
  */
trait Strategy {
      def triggerAction:Unit
      def lastAction:java.time.LocalDateTime
}
