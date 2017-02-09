package BT

import BinTree._

class BSTTests extends org.scalatest.FunSuite {
  test("insert into empty tree"){
    assert(insert(200, "A", SLeaf()) == SNode(SLeaf(), 200, "A", SLeaf()))
  }

  test("insert into left-subtree"){
    assert(insert(200, "A", SNode(SLeaf(), 500, "B", SLeaf())) == SNode(SNode(SLeaf(), 200, "A", SLeaf()), 500, "B", SLeaf()))
  }

  test("insert and replace"){
    assert(insert(200,"A", SNode(SLeaf(), 200, "B", SLeaf())) == SNode(SLeaf(), 200, "A", SLeaf()))
  }

}