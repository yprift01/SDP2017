object Lecture1 {
  def fac(n: Int): Int = if (n==0) 1 else (n * fac(n-1))
}

object Examples {
  def countDown(n: Int): List[Int] = {
    if (n == 0) {
      Nil
    } else {
      n :: countDown(n - 1)
    }

  }


  def fromTo(lo: Int, hi: Int): List[Int] = {
    if (lo == hi) {
      lo :: Nil
    }
    else {
      lo :: fromTo(lo + 1, hi)
    }
  }
}

object Lists {
  def sum(lst: List[Int]): Int = {
    lst match {
      case Nil => 0
      case h :: t => h + sum(t)
    }
  }

  def product(lst: List[Int]): Int = {
    lst match {
      case Nil => 1
      case h::t => h * product(t)
    }
  }

  def countOnes(lst: List[Int]): Int = {
    lst match {
      case Nil => 0
      case h::t => {
        if (h==1) {
          1 + countOnes(t)
        }else {
          countOnes(t)
        }
      }

    }
  }

}