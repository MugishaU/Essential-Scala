
class Person(first: String = "John", last: String = "Doe") {
  val firstName = first
  val lastName = last
  def name: String = s"$firstName $lastName"
}

class Person2(val first: String = "Jane", val last: String = "Doe"){
  def name: String = s"$first $last"
}

object alien {
  def greet(p: Person2): String =
    s"Greetings, ${p.name}"
}

val john = new Person()
john.name

val mike = new Person2("Mike","Wazowski")
val unknown = new Person2()
val backwards = new Person2(last="stranger", first="you")


alien.greet(backwards)

def badness = throw new Exception("Error")

def otherBadness = null

val bar = if (false) 123 else null