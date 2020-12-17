sealed trait TrafficLight
case object Red extends TrafficLight
case object Yellow extends TrafficLight
case object Green extends TrafficLight

sealed trait Calculator
case class Success(value: Int) extends Calculator
case class Failure(value: String) extends Calculator

sealed trait Source
case object Well extends Source
case object Spring extends Source
case object Tap extends Source


case class BottledWater (size: Int, source: Source, carbonated: Boolean)