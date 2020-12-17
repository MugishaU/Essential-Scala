sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object Calculator {
  def +(calculation: Calculation, x: Int): Calculation =
    calculation match {
      case Success(result) => Success(result+x)
      case Failure(reason) => Failure(reason)
    }
  def -(calculation: Calculation, x: Int): Calculation =
    calculation match {
      case Success(result) => Success(result-x)
      case Failure(reason) => Failure(reason)
    }

  def /(calculation: Calculation, x: Int): Calculation =
    (calculation, x) match {
      case (Success(_), 0) => Failure("Division by zero")
      case (Success(result), x) => Success(result/x)
      case (Failure(reason), _) => Failure(reason)
    }
}

assert(Calculator.+(Success(1), 1) == Success(2))
assert(Calculator.-(Success(1), 1) == Success(0))
assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))

assert(Calculator./(Success(4), 2) == Success(2))
assert(Calculator./(Success(4), 0) == Failure("Division by zero"))
assert(Calculator./(Failure("Badness"), 0) == Failure("Badness"))