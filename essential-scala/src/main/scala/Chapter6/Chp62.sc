val seq = Seq(1,2,3,4,5,6,7,9,10)
seq.map(_*2)
"dog".toSeq.permutations.toList
Seq("a","wet","dog").flatMap(_.toSeq.permutations.toList)

seq.map(_.toDouble).foldLeft(1.0)(_ / _)
seq.foreach(num => println(s"And a $num ..."))