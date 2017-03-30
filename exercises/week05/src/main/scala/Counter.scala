/**
  * Created by yprift01 on 30/03/17.
  */

package week05

class Counter(var count:Int ) {

  def inc(c:Int = 1): Counter ={
    return new Counter(count+c)
  }
  def dec(c:Int = 1): Counter = {
    return new Counter(count-c)
  }

  def adjust(adder:Adder):Counter = new Counter(adder.add(count))
}


