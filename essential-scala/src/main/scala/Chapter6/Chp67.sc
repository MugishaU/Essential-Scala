val seq1 = Seq(1,2,3)
for {
  x <- seq1 if x > 0
} yield x

val seq2 = Seq(4,5,6)

for {
  x <- seq1.zip(seq2)
} yield {val (a,b) = x; a+b}

for {
  x <- seq2.zipWithIndex
} yield {val (a,b) = x; (b,a)}

for {
  x <- seq1
  square = x*x if square % 2 != 0
  y <- seq2
} yield  square * y