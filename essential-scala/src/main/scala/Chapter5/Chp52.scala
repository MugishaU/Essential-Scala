package Chapter5

object Chp52 {

  sealed trait IntList {

    def fold[A](end: A, f: (Int, A) => A): A =
      this match {
        case End => end
        case Pair(hd, tl) => f(hd, tl.fold(end, f))
      }

    def length: Int =
      fold[Int](0, (_,tl) => 1 + tl)

    def double: IntList =
      fold[IntList](End, (hd, tl)=>Pair(hd*2, tl))

    def product: Int =
      fold[Int](1, (hd, tl) => hd * tl)

    def sum: Int =
      fold[Int](0, (hd,tl) => hd + tl)

  }


  case object End extends IntList
  final case class Pair(hd: Int, tl: IntList) extends IntList

  val example: IntList = Pair(1, Pair(2, Pair(3, End)))

  def main(args: Array[String]): Unit = {
    assert(example.length == 3)
    assert(example.product == 6)
    assert(example.sum == 6)
    assert(example.double == Pair(2, Pair(4, Pair(6, End))))

  }

}


