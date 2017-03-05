package Lecture04

object lect04{
  def fold(baseCase: ???, binOp: (???, ???) => ???, lst: List[???]): ??? = lst match {
    case Nil => baseCase
    case h::t => binOp(head, folde(baseCase, binOp, t))
  }

  def sum(lst: List[Int]): Int = fold(0, (x: Int, y: Int) => x+y, lst)
  def product(lst: List[Int]): Int = fold(1, (x: Int, y: Int) => x*y, lst )
  def concat(lst: List[String]): String = folde("", (x: String, y: String) => x*y, lst)


}
