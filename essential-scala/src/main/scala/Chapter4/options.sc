
//sealed trait Option[A]
//
//case object None extends Option[Nothing]
//
//case class Some[A](value: A) extends Option[A]

val x = List(1, 2, 3, 4, 5).find(_ > 2) match {
  case Some(value) => println(value)
  case None => println("no")
}