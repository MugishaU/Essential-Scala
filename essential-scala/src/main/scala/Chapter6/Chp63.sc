val seq = Seq(1,2,3)

seq.map(_ * 2)

for {
  x <- seq
} yield x * 2

val data = Seq(Seq(1), Seq(2, 3), Seq(4, 5, 6))

data.flatMap(_.map(_*2))

for {
  subseq <- data
  element <- subseq
} yield element * 2

