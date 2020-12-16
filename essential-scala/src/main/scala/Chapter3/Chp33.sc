class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int, minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

Timestamp(365,1,0).seconds

class Person(val firstName: String, val lastName: String)

object Person{
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0),parts(1))
  }
}

Person("John Doe").firstName

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name: String = s"$firstName $lastName"
}

object Director{
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = {
    new Director(firstName,lastName,yearOfBirth)
  }

  def older (first: Director, second: Director): String = {
    if (first.yearOfBirth < second.yearOfBirth) first.name else second.name
  }
}

assert(Director.older(new Director("older","man",1980),new Director("younger","man",1990))== "older man")
assert(Director("John","Doe",1980).name == "John Doe")

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director){
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(person: Director) = if(person.name == director.name) true else false
  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating, director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

object Film{
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film =
    new Film(name, yearOfRelease, imdbRating, director)
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

assert(Film("Avengers",2012,7.8,Director("Joss", "Whedon", 1980)).name == "Avengers")
assert(Film.highestRating(new Film("higher rating",2012,8.5,Director("Joss", "Whedon", 2000)),new Film("film",2012, 7,Director("older","guy",1980))) == "higher rating")
assert(Film.oldestDirectorAtTheTime(new Film("higher rating",2012,8.5,Director("Joss", "Whedon", 2000)),new Film("film",2012, 7,Director("older","guy",1980))).name == "older guy")