import Strategy.{Runner, StrategyClient}

import scala.collection.mutable.ListBuffer

/**
  * Created by yprift01 on 09/04/17.
  */
object StrategyFactory {

  def BaseStrategy: ListBuffer[StrategyClient] = {
      val stgClients = new ListBuffer[StrategyClient]()
    stgClients += new Runner(new Strategy.Call("0123456"))
    stgClients += new Runner(new Strategy.Call("0323454"))
    stgClients += new Runner(new Strategy.Siren())
  }

}
