sealed trait TrafficLight{
  def next: TrafficLight
  def next2 : TrafficLight = {
    this match {
      case Red => Green
      case Yellow => Red
      case Green => Yellow
    }
  }
}
case object Red extends TrafficLight {
  val next = Green
}
case object Yellow extends TrafficLight{
  val next = Red
}
case object Green extends TrafficLight{
  val next = Yellow
}

object controller{
  def next (trafficLight: TrafficLight): TrafficLight = {
    trafficLight match {
      case Red => Green
      case Yellow => Red
      case Green => Yellow
    }
  }
}
