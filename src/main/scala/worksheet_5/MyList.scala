trait MyList[+X]
//case object MyNil extends MyList[Nothing]
//case class MyCons[+X] ()

def length [X] (xs:MyList[X]) : Int = {
    xs match { // pattern match
        case MyNil => 0 // empty list
        case MyCons(_, ys) => 1 + length(ys)
        // (_, ys)
            // _ is when you ignore the head of the list
            // ys is the tail of the list (everything after the head)
        // 1 + length(ys)
            // recursive length; add 1 for each iteration
            // 1 is current head
            // length(ys) is the tail

    }
}

def toList [X] (xs:MyList[X]) : Int = {
    xs match {
        case MyNil => 0
        case MyCons(y, ys) => y::toList(ys)
                            // head::toList(tail)
        // (y, ys) because you need to extract both the head and tail, you don't need to ignore the head
        // see here you need the actual value, there you don't you just need the count
        // y::toList(ys)
            // prepend y to ys


        // ex. val myList = MyCons(1, MyCons(2, MyCons(3, MyNil)))
            // y = 1 and ys = MyCons(2, MyCons(3, MyNil))
            // once recursion is over you return the prepend

            // Return from Fourth Call: Returns Nil.
            // Return from Third Call: Returns 3 :: Nil which results in List(3).
            // Return from Second Call: Returns 2 :: List(3) which results in List(2, 3).
            //Return from First Call: Returns 1 :: List(2, 3) which results in List(1, 2, 3).
    }
}

def fromList [X] (xs:List[X]) : MyList[X] = {

}

def append [X] (xs:MyList[X], ys:MyList[X]) : MyList[X] = {

}

def map [X,Y] (xs:MyList[X], f:X=>Y) : MyList[X] = {

}