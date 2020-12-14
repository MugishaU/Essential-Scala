def square(in: Double): Double = in * in

assert(square(2.0) == 4.0)
assert(square(3.0) == 9.0)
assert(square(-2.0) == 4.0)

{
  println("Side Effect")
  val a = 5
  3 + a
}