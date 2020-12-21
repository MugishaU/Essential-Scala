import scala.annotation.tailrec

sealed trait IntList
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

val example = Pair(1, Pair(2, Pair(3,End)))


def sum(list: IntList): Int =
  list match {
    case End => 0
    case Pair(hd, tl) => hd + sum(tl)
  }

@tailrec
def tailSum(list: IntList, total:Int = 0): Int =
  list match {
    case End => total
    case Pair(hd, tl) => tailSum(tl, total + hd)
  }

assert(sum(example) == 6)
assert(sum(example.tail) == 5)
assert(sum(End) == 0)


tailSum(example)