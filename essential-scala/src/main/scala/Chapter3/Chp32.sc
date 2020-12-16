class Adder(val amount: Int){
  def apply(in: Int): Int = in + amount
}

val add3 = new Adder(3)
add3(4)
add3(17)
