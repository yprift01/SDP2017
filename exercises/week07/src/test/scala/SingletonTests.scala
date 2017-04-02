/**
  * Created by yprift01 on 02/04/17.
  */
package singleton
import org.scalatest.FunSuite
class SingletonTests extends FunSuite{
  test("Singleton Protect Eager Initialize") {
    assert(SingletonProtected.getInstance() == null)
  }
}
