trait Tree[+X]
case object Leaf extends Tree[Nothing]
case class Node[+X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]

/*
trait Tree[+X]
case object Leaf extends Tree[Nothing]
case class Node[X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]
*/

val tree1:Tree[Int] = Leaf // val is immutable & var is mutable
val tree2:Tree[Int] = Node (Leaf, 5, Leaf)
val tree3:Tree[Int] = Node (Node (Leaf, 2, Leaf), 3, Node(Leaf, 4, Leaf))

def size [X] (t:Tree[X]): Int = {
    t match { // this is t because you need to match the variable name in the parameter
        case Leaf => 0;
        case Node(left,num,right) => 1 + size(left) + size(right);
        // you could choose to ignore the middle or not, your choice really
    }
}

