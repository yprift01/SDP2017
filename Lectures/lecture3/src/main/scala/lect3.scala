package lect3

object Lecture3 {
  def map[A, B](f: A => B, lst: List[A]):List[B] =
    lst match{
      case Nil => Nil
      case h::t => f(h)::map[A,B](f,t)
    }

  def doubles(lst: List[Int]) = {
    def f(n: Int): Int = n * 2
    map (f, lst)
  }

  def incrs(lst: List[Int]): List[Int] = {
    def f(n: Int): Int = n+1
    map (f, lst)
  }
  def lengths(lst: List[String]):List[Int] = {
    def f(str: String): Int = str.length
    map(f, lst)
  }
}