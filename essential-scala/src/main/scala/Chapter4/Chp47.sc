sealed trait Calculation
final case class Success(result: Double) extends Calculation
final case class Failure(reason: String) extends Calculation

sealed trait Expression{
  def eval: Calculation =
    this match {
      case Addition(l, r) => l.eval match {
        case Failure(reason) => Failure(reason)
        case Success(result1) => r.eval match {
          case Failure(reason) => Failure (reason)
          case Success(result2) => Success(result1 + result2)
        }
      }
      case Subtraction(l, r) => l.eval match {
        case Failure(reason) => Failure(reason)
        case Success(result1) => r.eval match {
          case Failure(reason) => Failure (reason)
          case Success(result2) => Success(result1 - result2)
        }
      }
      case Division(l, r) => l.eval match {
        case Failure(reason) => Failure(reason)
        case Success(result1) => r.eval match {
          case Failure(reason) => Failure(reason)
          case Success(result2) => if (result2 != 0) Success(result1 / result2) else Failure("Division by zero")
        }
      }
      case SquareRoot(value) => value.eval match {
        case Failure(reason) => Failure(reason)
        case Success(result) => if (result > 0) Success(Math.sqrt(result)) else Failure("Square root of negative number")
      }
      case Number(value) => Success(value)

    }
}
final case class Addition (l: Expression, r:Expression) extends Expression
final case class Subtraction (l: Expression, r: Expression) extends Expression
final case class Division (l: Expression, r: Expression) extends Expression
final case class SquareRoot (value: Expression) extends Expression
final case class Number (value: Double) extends Expression

assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval == Failure("Square root of negative number"))
assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success (4.0))
assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))