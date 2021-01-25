def minimum(seq: Seq[Int]): Option[Int] = {
  seq.sortWith(_ < _).headOption
}

val seq = Seq(1,2,3,4)

def reverse[A](seq: Seq[A]): Seq[A] = {
  seq.foldRight(Seq.empty[A]){(next,seq) => seq :+ next}
}

def map(seq: Seq[Int], fn: Int => Int): Seq[Int] = {
  seq.foldLeft(Seq.empty[Int]){(seq,next) => seq :+ fn(next)}
}


assert(reverse(seq) == Seq(4,3,2,1))
assert(map(seq, x => x * 2) == Seq(2,4,6,8))
