object Test {
  def name: String = "Probably the best object ever"
  def hello (name: String = "there"):String = "Hello " + name
}

object Test4 {
  val name = "Noel"
  def hello(other: String):String ={
    name + " says hi to " + other
  }
}

object Test7 {
  val simpleField = {
    println("Evaluating simpleField")
    42
  }

  def noParameterMethod = {
    println("Evaluating noParameterMethod")
    42
  }
}

Test7.simpleField
Test7.simpleField

Test7.noParameterMethod
Test7.noParameterMethod

object Cat1 {
  val name = "Oswald"
  val colour = "Black"
  val food = "Milk"
}

Cat1.name
Cat1.name

object calc {
  def square(x: Double):Double = {
    x*x
  }
}


object calc2 {
  def square(x: Double):Double = {
    x*x
  }

  def square(x: Int):Int = {
    x*x
  }
}

calc square 3.7

calc2 square 4
calc2 square 4.0

object Person {
  val firstName = "John"
  val lastName = "Doe"
}

object Alien {
  def greet (person: Person.type):String = {
    "Hello " + person.firstName + "!"
  }
}

Alien.greet(Person)

