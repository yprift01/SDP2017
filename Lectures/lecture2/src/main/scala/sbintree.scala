package BT

sealed trait SBinTree
case class SNode(lhs: SBinTree, key: Int, value: String, rhs: SBinTree) extends SBinTree
case class SLeaf() extends  SBinTree

object BinTree{
  def find(k: Int, t: SBinTree): String = t match{
    case SLeaf() => sys.error("Not Found")
    case SNode(_, key, value, _) if (k==key) => value
    case SNode(lhs, key, _, _) if (k <= key) => find(k, lhs)
    case SNode(_, key, _, rhs) => find(k, rhs)
  }

  def insert(k: Int, v: String, t: SBinTree): SBinTree = t match {
    case SLeaf() => SNode(SLeaf(), k, v, SLeaf())
    case SNode(lhs, key, _, rhs) if(k==key) => SNode(lhs, key, v, rhs)
    case SNode(lhs, key, value, rhs) if (k<=key) => SNode(insert(k, v, lhs), key, value, rhs)
    case SNode(lhs, key, value, rhs) => SNode(lhs, key, value, insert(k, v, rhs))
  }

  def size(t: SBinTree): Int = t match{
    case SLeaf() => 1
    case SNode(lhs, k, v, rhs) => size(lhs) + size(rhs) + 1
  }
}