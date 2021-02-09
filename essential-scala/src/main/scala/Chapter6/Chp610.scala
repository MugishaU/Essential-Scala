package Chapter6

object Chp610 {
  val subjects = List("Noel","The cat","The dog")
  val verbs = List("wrote","chased","slept on")
  val objects = List("the book","the ball","the bed")

  def sentence: List[String] = {
    for{
      subject <- subjects
      verb <- subject match {
        case "Noel" => List("wrote","chased","slept on")
        case "The cat" => List("meowed at","chased","slept on")
        case "The dog" => List("barked at","chased","slept on")
      }
      object1 <- verb match {
        case "wrote" => List("the book", "the letter", "the code")
        case "chased" => List("the ball", "the dog", "the cat")
        case "slept on" => List("the bed", "the mat", "the train")
        case "meowed at" => List("Noel","the door","the food cupboard")
        case "barked at" => List("the postman","the car","the cat")
      }
    } yield s"$subject $verb $object1"
  }

//  def main(args: Array[String]): Unit = {
//    sentence.foreach(println(_))
//    println(sentence.size)
//  }
}
