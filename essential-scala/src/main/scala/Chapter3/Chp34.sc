case class Person(firstName: String, lastName: String) {
  def name = s"$firstName $lastName"
}

val john = Person("John","Doe")
Person
john

john == Person("John","Doe")

john.copy(lastName = "Smith")

case class Cat( colour: String, food: String)

case class Director(firstName: String, lastName: String, yearOfBirth: Int){
  def name: String = s"$firstName $lastName"
}

object Director{
  def older (first: Director, second: Director): String = {
    if (first.yearOfBirth < second.yearOfBirth) first.name else second.name
  }
}

case class Film( name: String, yearOfRelease: Int, imdbRating: Double, director: Director){
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(person: Director) = if(person.name == director.name) true else false
}

object Film{
  def highestRating(first: Film, second: Film): String =
    if(first.imdbRating > second.imdbRating)
      first.name
    else if(first.imdbRating < second.imdbRating)
      second.name
    else
      "Same imdb rating"
  def oldestDirectorAtTheTime(first: Film, second: Film): Director =
    if(first.directorsAge > second.directorsAge)
      first.director
    else if(first.directorsAge < second.directorsAge)
      second.director
    else {
      println{"Directors same age, returning first entered"}
      first.director
    }
}


case class Counter(count: Int = 0){
  def inc: Counter = copy(count = count + 1)
  def dec: Counter = copy(count = count - 1)

}