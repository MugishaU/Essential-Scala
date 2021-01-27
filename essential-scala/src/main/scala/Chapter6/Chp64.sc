//def addOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
//  for {
//    tryA: Int <- a
//    tryB <- b
//  } yield tryA + tryB
//}
//
//def addOptions(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = {
//  for {
//    tryA <- a
//    tryB <- b
//    tryC <- c
//  } yield tryA + tryB + tryC
//}
//
//def addOptions2(op1: Option[Int], op2: Option[Int]): Option[Int] = {
//  op1.flatMap(a => op2.map(b => a+b))
//}
//
//def addOptions2(op1: Option[Int], op2: Option[Int], op3: Option[Int]): Option[Int] = {
//  op1.flatMap(a => op2.flatMap( b => op3.map( c => a + b + c)))
//}
//
//addOptions2(Option(10), Option(8), Option(4))

def divide(a: Int, b: Int): Option[Int] = {
  b match {
    case 0 => None
    case _ => Option( a / b)
  }
}

def divideOptions(a: Option[Int], b: Option[Int]): Option[Int] = {
  for {
    num <- a
    den <- b
    c <- divide(num,den)
  } yield c
}

divideOptions(Option(6),Option(3))