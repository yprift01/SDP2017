package Strategy

/**
  * Created by yprift01 on 09/04/17.
  */
class Runner(var strategy: Strategy) extends StrategyClient {

  override def triggerAction: Unit = strategy.triggerAction
  override def lastAction = strategy.lastAction

}
