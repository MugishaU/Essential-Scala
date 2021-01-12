package Chapter5

object Chp55 {

  sealed trait LinkedList[A]{
    def map[B](fn: A => B ): LinkedList[B] = {
      this match {
        case Pair(hd, tl) => Pair(fn(hd), tl.map(fn))
        case End() => End[B]()
      }
    }
  }

  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
  final case class End[A]() extends LinkedList[A]

  sealed trait Maybe[A]{
    def map[B](fn: A => B): Maybe[B] = {
      this match {
        case Full(value) => Full(fn(value))
        case Empty() => Empty[B]()
      }
    }

    def flatMap[B](fn: A => Maybe[B]): Maybe[B] = {
      this match {
        case Full(value) => fn(value)
        case Empty() => Empty[B]()
      }
    }
  }

  final case class Full[A](value: A) extends Maybe[A]
  final case class Empty[A]() extends Maybe[A]

  val list: LinkedList[Int] = Pair(1, Pair(2, Pair(3, End())))
  val list2: List[Maybe[Int]] = List(Full(3), Full(2), Full(1))


//  def main(args: Array[String]): Unit = {
//    println(list.map(_ * 2))
//    println(list.map(_ + 1))
//    println(list.map(_ / 3))
//    println(list2.map(maybe => maybe.flatMap[Int] { x => if (x % 2 == 0) Full(x) else Empty() } ))
//  }


}
