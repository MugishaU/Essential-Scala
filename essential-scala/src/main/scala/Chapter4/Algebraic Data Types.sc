// If A has a b (type B) and a c (type C) Product type
case class A (b: B, c: C)
Or
trait A {
  def b: B
  def c: C
}

//If A is a B or C: Sum type
sealed trait A
final case class B() extends A
final case class C() extends A

//If A is a B and a C: Inverse Sum type
trait B
trait C
trait A extends B with C

//If A has a B or a C:
trait A {
  def d:D
}
sealed trait D
final case class B() extends D
final case class C() extends D
Or
sealed trait A
final case class D(b: B) extends A
final case class E(c: C) extends A