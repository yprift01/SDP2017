package fibonacci

import akka.actor.{ActorSystem, ActorLogging, Actor, Props}

object Fibonacci extends App {

  val l = List(3,4,12,22,1)

  val system = ActorSystem("system")

  system.actorOf(Props(new FibonacciListActor(l)), "collector")

}

class FibonacciListActor(fib:List[Int]) extends Actor with ActorLogging {

  var size = fib.length

  //fib.foreach(x=> Props(new FibonacciCalculator(x)))

  for (n <- fib){
    context.actorOf(Props(new FibonacciCalculator)) ! n
  }

  def receive = {
    case(num: Int, res: List[Int]) => {

      log.info(s"$num $res")

      size = size-1
      if(size==0) {
        context.system.terminate()
      }
    }
  }

}

class FibonacciCalculator extends Actor  {

  def receive={
    case num:Int =>  sender ! (num, calculate(num))
  }

  def calculate(len: Int ):List[Int] = {
    len match {
      case 0 => List(0)
      case 1 => calculate(0) :+ 1
      case n => {
        val current = calculate(n-1)
        val currentCalc = current(n-1) + current(n-2)
        current :+ currentCalc
      }
    }
  }

}