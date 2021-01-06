package Chapter5

object Chp53 {
  sealed trait LinkedList[A]{
    def fold[B](end: B, f: (A,B)=> B): B = {
      this match {
        case End() => end
        case Pair(head, tail) => f(head, tail.fold(end, f))
      }
    }
  }
  final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
  final case class End[A]() extends LinkedList[A]

}
