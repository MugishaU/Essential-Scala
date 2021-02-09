package Chapter6

class Chp6102 {

  final case class Distribution[A](events: List[(A,Double)]){

    def normalize: Distribution[A] = {
      val totalWeight = (events map { case (a, p) => p }).sum
      Distribution(events map { case (a,p) => a -> (p / totalWeight) })
    }

  def map[B](f: A => B): Distribution[B] = {
      val newEvents = events.map( event =>(f(event._1), event._2))
      Distribution(newEvents)
    }

    def compact: Distribution[A] = {
      val distinct = (events map { case (a, p) => a }).distinct
      def prob(a: A): Double =
        (events filter { case (x, p) => x == a } map { case (a, p) => p }).sum
      Distribution(distinct map { a => a -> prob(a) }) }

  def flatMap[B](f: A => Distribution[B]): Distribution[B] = {
      val newEvents = events flatMap { case (a, p1) =>
        f(a).events map { case (b, p2) => b -> (p1 * p2) } }
      Distribution(newEvents).compact.normalize
  }}

  object Distribution{
    def uniform[A](list: List[A]) : Distribution[A] = {
      val probability = 1.0/list.length
      val events = list.map((_,probability))
      Distribution(events)
    }
  }
}
