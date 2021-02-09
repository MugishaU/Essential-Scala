package Chapter5

object Chp5544 {
  sealed trait Sum[A, B] {
    def fold[C](success: A => C, failure: B => C): C =
      this match {
        case Success(a) => success(a)
        case Failure(b) => failure(b)
      }

    def map[C](f: A => C): Sum[C,B] = {
      this match {
        case Failure(value) => Failure(value)
        case Success(value) => Success(f(value))
      }
    }

    def flatMap[C](f: A => Sum[C,B]): Sum[C,B] = {
      this match {
        case Failure(value) => Failure(value)
        case Success(value) => f(value)
      }
    }
  }
  final case class Failure[A, B](value: B) extends Sum[A, B]
  final case class Success[A, B](value: A) extends Sum[A, B]

  val list = List(1,2,3)
//  def main(args: Array[String]): Unit = {
//    println(list.flatMap(x => List(x,-x)))
//  }


}
