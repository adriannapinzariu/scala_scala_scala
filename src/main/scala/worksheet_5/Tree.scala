trait Tree[+X]
case object Leaf extends Tree[Nothing]
case object Node[+X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]

/*
trait Tree[+X]
case object Leaf extends Tree[Nothing]
case class Node[X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]
*/
