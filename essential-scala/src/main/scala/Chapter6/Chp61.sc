//val seq = Seq(1,2,3,5,6,7,8,9,10)
//seq.headOption
//seq.length
//seq.contains(1)
//seq.find(_ > 5)
//seq.filter(_ % 2 == 0)
//seq.sortWith(_ > _)
//8 +: seq :+ 8 :+ 9
// seq ++ List(11,12,13)
//1 :: 2 :: Nil

//val animals = Seq("cat","dog","penguin")
//"mouse" +: animals :+ "tyrannosaurus"

case class Film(name: String, yearOfRelease: Int, imdbRating: Double)
case class Director(firstName: String, lastName: String, yearOfBirth: Int, films: Seq[Film])

val memento = Film("Memento", 2000, 8.5)
val darkKnight = Film("Dark Knight", 2008, 9.0)
val inception = Film("Inception", 2010, 8.8)

val highPlainsDrifter = Film("High Plains Drifter", 1973, 7.7)
val outlawJoseyWales = Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven = Film("Unforgiven", 1992, 8.3)
val granTorino = Film("Gran Torino", 2008, 8.2)
val invictus = Film("Invictus", 2009, 7.4)

val predator = Film("Predator", 1987, 7.9)
val dieHard = Film("Die Hard", 1988, 8.3)
val huntForRedOctober = Film("The Hunt for Red October", 1990,7.6)
val thomasCrownAffair = Film("The Thomas Crown Affair", 1999, 6.8)

val eastwood = Director("Clint", "Eastwood", 1930, Seq(highPlainsDrifter, outlawJoseyWales, unforgiven, granTorino, invictus))
val mcTiernan = Director("John", "McTiernan", 1951, Seq(predator, dieHard, huntForRedOctober, thomasCrownAffair))
val nolan = Director("Christopher", "Nolan", 1970, Seq(memento, darkKnight, inception))
val someGuy = Director("Just", "Some Guy", 1990, Seq())
val directors = Seq(eastwood, mcTiernan, nolan, someGuy)

def moreFilmsThan(numberOfFilms: Int): Seq[String] = {
  directors.filter(_.films.length > numberOfFilms).map(_.firstName)
}

def bornBefore(year: Int): Seq[String] = {
  directors.filter(_.yearOfBirth < year).map(_.firstName)
}

def filmAndBorn(year: Int, numberOfFilms: Int): Seq[String] = {
  directors.filter(_.films.length > numberOfFilms).filter(_.yearOfBirth < year).map(_.firstName)
}

def order(ascending: Boolean = true): Seq[String] = {
  directors.sortWith(_.yearOfBirth > _.yearOfBirth == ascending).map(_.firstName)
}

bornBefore(1984)
moreFilmsThan(4)
filmAndBorn(1990,3)
order(false)