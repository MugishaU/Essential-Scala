val people = Set(
  "Alice",
  "Bob",
  "Charlie",
  "Derek",
  "Edith",
  "Fred"
)
val ages = Map( "Alice" -> 20, "Bob" -> 30, "Charlie" -> 50, "Derek" -> 40, "Edith" -> 10, "Fred" -> 60)
val favoriteColors = Map( "Bob" -> "green", "Derek" -> "magenta", "Fred" -> "yellow")
val favoriteLolcats = Map( "Alice" -> "Long Cat", "Charlie" -> "Ceiling Cat", "Edith" -> "Cloud Cat")

def favouriteColour(name:String):String = {
  favoriteColors.getOrElse(name,"beige")
}

def printColors(): Unit = {
  favoriteColors.foreach(pair => println(pair._2))
}

def lookup[A](name: String, map: Map[String,A]): Option[A] = {
  map.get(name)
}

favouriteColour("Derek")
printColors()
lookup("Bob",favoriteLolcats)
