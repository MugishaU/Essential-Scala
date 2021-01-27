def calculator(operand1: String, operator: String, operand2: String): Unit = {
  def convertOperand(input: String): Option[Int] = {
    if(input matches "-?\\d+") Some(input.toInt) else None
  }

  val input1 = convertOperand(operand1)
  val input2 = convertOperand(operand2)

  def plusOption(op1: Option[Int], op2: Option[Int]): Option[Int] = {
    for {
      a <- op1
      b <- op2
    } yield a + b
  }

  def minusOption(op1: Option[Int], op2: Option[Int]): Option[Int] = {
    for {
      a <- op1
      b <- op2
    } yield a - b
  }

  def multiplyOption(op1: Option[Int], op2: Option[Int]): Option[Int] = {
    for {
      a <- op1
      b <- op2
    } yield a * b
  }

  def divide(num: Int, den: Int): Option[Int] = {
    if (den == 0) None else Option(num/den)
  }

  def divideOption(op1: Option[Int], op2: Option[Int]): Option[Int] = {
    for {
      a <- op1
      b <- op2
      c <- divide(a, b)
    } yield c
  }

  val result =
    operator match {
        case "+" => plusOption(input1, input2)
        case "-" => minusOption(input1, input2)
        case "*" => multiplyOption(input1, input2)
        case "/" => divideOption(input1, input2)
        case _ => None
    }

  if (result.isDefined) println(s"$operand1 $operator $operand2 = ${result.get}") else println(s"$operand1 $operator $operand2 is invalid")

}

calculator("5","+", "0")
