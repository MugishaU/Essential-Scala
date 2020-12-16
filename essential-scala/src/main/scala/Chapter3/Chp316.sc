
class Cat (val colour: String, val food: String = "Cat Food")

val oswald = new Cat ("Black", "Milk")
val henderson = new Cat ("Ginger", "Chips")
val quentin = new Cat ("Tabby & white", "Curry")

object ChipShop{
  def willServe (cat: Cat): Boolean =
    if (cat.food == "Chips") true else false
}

assert(!ChipShop.willServe(oswald))
assert(ChipShop.willServe(henderson))

class Director(val firstName: String, val lastName: String, val yearOfBirth: Int){
  def name: String = s"$firstName $lastName"
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director){
  def directorsAge: Int = yearOfRelease - director.yearOfBirth
  def isDirectedBy(person: Director) = if(person.name == director.name) true else false
  def copy(name: String = this.name, yearOfRelease: Int = this.yearOfRelease, imdbRating: Double = this.imdbRating, director: Director = this.director): Film = {
    new Film(name, yearOfRelease, imdbRating, director)
  }
}

val eastwood = new Director ("Clint", "Eastwood", 1930)
val mcTiernan = new Director ("John", "McTiernan", 1951)
val nolan = new Director ("Christopher", "Nolan", 1970)
val someBody = new Director ("Just", "Some Body", 1990)

val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7,eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9,eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)

val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990,7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8,mcTiernan)

eastwood.yearOfBirth
// res16: Int = 1930
dieHard.director.name
// res17: String = John McTiernan
invictus.isDirectedBy(nolan)
// res18: Boolean = false

val a = highPlainsDrifter.copy(name = "L'homme des hautes plaines")
// res19: Film = Film(L'homme des hautes plaines,1973,7.7,Director(
//Clint,Eastwood,1930))
val b = thomasCrownAffair.copy(yearOfRelease = 1968, director = new Director("Norman", "Jewison", 1926))
// res20: Film = Film(The Thomas Crown Affair,1968,6.8,Director(Norman ,Jewison,1926))
val c = inception.copy().copy().copy()
// res21: Film = Film(Inception,2010,8.8,Director(Christopher,Nolan ,1970))

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class Counter(val count: Int = 0){
  def inc: Counter = inc()

  def dec: Counter = dec()

  def inc(step: Int = 1): Counter= {
    new Counter (count = this.count+step)
  }

  def dec(step: Int = 1): Counter= {
    new Counter (count = this.count-step)
  }

  def adjust(adder: Adder): Counter = {
    new Counter (adder.add(count))
  }

}

new Counter(10).inc.dec.inc.inc.count
// res23: Int = 12

new Counter(10).inc.inc(10).count
// res25: Int = 21

new Counter().adjust(new Adder(10) ).count