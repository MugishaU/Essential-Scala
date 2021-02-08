val exm = scala.collection.mutable.Map("a"->1,"b"->2,"c"->3)

exm("a")
exm.get("b")
exm.getOrElse("d",-1)
exm.contains("c")
exm.size

exm += ("d"->4)

exm("e") = 10
exm.map(pair => pair._1+1 -> pair._2*7)
