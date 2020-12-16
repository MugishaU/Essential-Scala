case class Cat (val colour: String, val food: String = "Cat Food")

val oswald = new Cat ("Black", "Milk")
val henderson = new Cat ("Ginger", "Chips")
val quentin = new Cat ("Tabby & white", "Curry")

object ChipShop{
  def willServe (cat: Cat): Boolean =
//    cat.food match {
//      case "Chips" => true
//      case _ => false
//    }

  cat match {
    case Cat(_,"Chips") => true
    case Cat(_,_) => false
  }
}

assert(!ChipShop.willServe(oswald))
assert(ChipShop.willServe(henderson))

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
    if(first.imdbRating > second.imdbRating) first.name else second.name

  def oldestDirectorAtTheTime(first: Film, second: Film): Director =
    if(first.directorsAge > second.directorsAge) first.director else second.director
  }

object Dad {
  def rate(film: Film): Double = {
    film.director.name match {
      case "Clint Eastwood" => 10
      case "John McTiernan" =>7
      case _ => 3
    }
  }
}

assert(Dad.rate(Film("name",123,7,Director("Clint","Eastwood",123)))==10)
assert(Dad.rate(Film("name",123,7,Director("John","McTiernan",123)))==7)
assert(Dad.rate(Film("name",123,7,Director("Bob","Smith",123)))==3)