sealed trait Colour {
  def R: Int
  def G: Int
  def B: Int

  def shade: String = {
    if (R <= 100 && G <= 100 && B <= 100) "dark" else "light"
  }
}

case object Yellow extends Colour {
  val R = 255
  val G = 255
  val B = 0
}

case object Red extends Colour {
  val R = 255
  val G = 0
  val B = 0
}

case object Pink extends Colour {
  val R = 255
  val G = 0
  val B = 255
}

case class CustomColour (R: Int, G: Int, B: Int) extends Colour

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def colour: Colour
}

sealed trait Rectangular extends Shape {
  val sides = 4
  def width: Double
  def length: Double
  def colour: Colour

  val perimeter: Double = 2*width + 2*length
  val area: Double = width * length
}

case class Rectangle (width: Double, length: Double, colour:Colour) extends Rectangular

case class Square (side: Double, colour: Colour) extends Rectangular {
  def width: Double = side
  def length: Double = side
}

case class Circle (radius: Double, colour:Colour) extends Shape{
  val sides = 1
  val perimeter: Double = 2*math.Pi*radius
  val area: Double = math.Pi*math.pow(radius,2)
}


object Draw {
  def apply(shape: Shape): String = {
    def col (colour: Colour):String ={
      colour match {
        case Yellow => "yellow"
        case Red => "red"
        case Pink => "pink"
        case colour => colour.shade
      }
    }

    shape match {
      case Circle(radius, colour) => s"A ${col(colour)} circle of radius $radius cm"
      case Rectangle(width, length, colour) => s"A ${col(colour)} rectangle of width ${width}cm and height ${length}cm"
      case Square(size, colour) => s"A ${col(colour)} square of size ${size}cm"
    }
  }
}

Draw(Circle(10, Pink))
// res29: String = A pink circle of radius 10.0cm
Draw(Rectangle(3, 4, CustomColour(200, 13, 45)))
// res30: String = A dark rectangle of width 3.0cm and height 4.0cm

//sealed trait DivisionResult {
//  def result: String
//}
//
//case object Infinite extends DivisionResult {
//  val result = "Infinite"
//}
//
//case class Finite(x:Int, y:Int) extends DivisionResult{
//  val result = s"Finite(${x/y})"
//}
//
//object divide {
//  def apply (x: Int, y:Int): String =
//    (x,y) match {
//      case (_,0) => Infinite.result
//      case (x,y) => Finite(x,y).result
//    }
//}
//
//val x = divide(1,2)
//val y = divide(1,0)

//___ REFACTOR ___
sealed trait DivisionResult

case object Infinite extends DivisionResult

case class Finite(value: Int) extends DivisionResult

object divide {
  def apply (x: Int, y:Int): DivisionResult =
    (x,y) match {
      case (_,0) => Infinite
      case (x,y) => Finite(x/y)
    }
}

val x = divide(1,2)
val y = divide(1,0)
val z = divide(0,30)
val a = divide.apply(25,5)
val b = divide.apply(0,0)