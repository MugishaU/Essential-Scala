trait Feline {
  def colour: String
  def sound: String
}

case class Cat (colour: String, food: String) extends Feline {
  val sound = "Meow"
}

case class Lion (colour: String, maneSize: Int) extends Feline {
  val sound = "Roar"
}

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle (radius: Double) extends Shape{
  val sides = 1
  val perimeter: Double = 2*math.Pi*radius
  val area: Double = math.Pi*math.pow(radius,2)
}

sealed trait Rectangular extends Shape {
  val sides = 4
  def width: Double
  def length: Double

  val perimeter: Double = 2*width + 2*length
  val area: Double = width * length
}

case class Rectangle (width: Double, length: Double) extends Rectangular

case class Square (side: Double) extends Rectangular {
  def width: Double = side
  def length: Double = side
}

object Draw {
  def apply(shape: Shape): String = {
    shape match {
      case Circle(radius) => s"A circle of radius $radius cm"
      case Rectangle(width, length) => s"A rectangle of width ${width}cm and height ${length}cm"
      case Square(size) => s"A square of size ${size}cm"
    }
  }
}

Draw(Circle(10))
Draw(Rectangle(3,4))