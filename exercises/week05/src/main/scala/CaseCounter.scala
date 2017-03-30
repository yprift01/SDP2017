/**
  * Created by yprift01 on 30/03/17.
  */

package week05
case class CaseCounter(count: Int = 0) {


  def inc(c:Int = 1): CaseCounter ={
    return CaseCounter(count+c)
  }
  def dec(c:Int = 1): CaseCounter = {
    return CaseCounter(count-c)
  }
  def adjust(adder:Adder):CaseCounter = CaseCounter(adder.add(count))
}
