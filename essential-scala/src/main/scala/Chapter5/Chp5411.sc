case class Pair[A,B](one: A,two: B)

val pair = Pair[String, Int]("hi", 2)
// pair: Pair[String,Int] = Pair(hi,2)
pair.one
// res0: String = hi
pair.two
// res1: Int = 2

pair

def tupilized[A,B,C](in: (A,B,C)): B= in._2

tupilized(1,2,3)
1+4

sealed trait Maybe[Int]

final case class Empty[Int]() extends Maybe[Int]
final case class Full(num: Int) extends Maybe[Int]