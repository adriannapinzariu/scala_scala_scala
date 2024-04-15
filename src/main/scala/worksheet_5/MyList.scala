trait MyList[+X]

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
    
}

def fromList [X] (xs:List[X]) : MyList[X] = {

}

def append [X] (xs:MyList[X], ys:MyList[X]) : MyList[X] = {

}

def map [X,Y] (xs:MyList[X], f:X=>Y) : MyList[X] = {

}