sealed trait Tree[A] {
  def fold[B](node: (B,B) => B, leaf: A => B): B
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  def fold[B](node: (B,B) => B, leaf: A => B): B = {
    println(s"left: $left \n right: $right\n")
    node(left.fold(node, leaf), right.fold(node, leaf))
  }
}
final case class Leaf[A](value: A) extends Tree[A] {

    def fold[B](node:  (B, B) => B, leaf:  A => B): B = {
      println(s"value: $value\n")
      leaf(value)
    }
}

val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")),
      Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))


tree.fold[String]((l,r)=> l + " " + r, str => str)
1+1