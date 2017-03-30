/**
  * Created by yprift01 on 30/03/17.
  */
package labs

import Hammurabi._
import org.scalatest.FunSuite

class HammurabiTests extends FunSuite {

  test("Buy Land Normal Case") {
    assert(Hammurabi.getToBuy() > 0)
  }

}
