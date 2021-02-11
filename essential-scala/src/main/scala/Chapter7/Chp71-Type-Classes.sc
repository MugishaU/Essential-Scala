import scala.math.{Ordering, abs}

final case class Rational(numerator: Int, denominator: Int)

val minOrdering: Ordering[Int] = Ordering.fromLessThan[Int](_ < _)
val maxOrdering: Ordering[Int] = Ordering.fromLessThan[Int](_ > _)
implicit val absOrdering: Ordering[Int] = Ordering.fromLessThan[Int](abs(_) < abs(_))
implicit val ratOrdering: Ordering[Rational] = Ordering.fromLessThan[Rational](
  (x,y) => {
    val xCheck = x.numerator.toDouble/x.denominator.toDouble
    val yCheck = y.numerator.toDouble/y.denominator.toDouble
    if (xCheck > yCheck) false else true
  }
)



assert(List(-4, -1, 0, 2, 3).sorted(absOrdering) == List(0, -1, 2, 3, -4))
assert(List(-4, -3, -2, -1).sorted(absOrdering) == List(-1, -2, -3, -4))

assert(List(-4, -1, 0, 2, 3).sorted == List(0, -1, 2, 3, -4))
assert(List(-4, -3, -2, -1).sorted == List(-1, -2, -3, -4))

assert(List(Rational(1, 2), Rational(3, 4), Rational(1, 3)).sorted == List(Rational(1, 3), Rational(1, 2), Rational(3, 4)))