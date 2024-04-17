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

/*
def size [X] (t:Tree[X]): Int = {
    t match { // this is t because you need to match the variable name in the parameter
        case Leaf => 0;
        case Node(left,num,right) => 1 + size(left) + size(right);
        // you could choose to ignore the middle or not, your choice really
    }
}
*/

def size [X] (t: Tree[X]): Int = {
    t match {
        case Leaf => 0;
        case Node(left, _, right) => 1 + size(left) + size(right);
    }
}

def insert [X] (x:X, t:Tree[X], lt:(X,X)=>Boolean) : Tree[X] = {
    t match {
        case Leaf => Node(Leaf, x, Leaf);
            // encountering an empty leaf means you have reached a point of insertion
            // you put x because it's the variable you want to insert
        case Node (left, mid, right) if (lt (x, mid)) => Node(insert(x, left, lt), mid, right);
            // lt is less than put left
        case Node (left, mid, right) if (lt (mid, x)) => Node(left, mid, insert(x, right, lt));
            // if greater than move right
        case Node (left, mid, right) if (x == mid) => Node(left, mid, right);
            // NO INSERTION BECAUSE DUPLICATE
    }
}