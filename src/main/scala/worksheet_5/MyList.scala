trait MyList[+X]
//case object MyNil extends MyList[Nothing]
//case class MyCons[+X] ()


def length [X] (xs:MyList[X]) : Int = {
    xs match { // pattern match
        case MyNil => 0 // empty list
        case MyCons(_, tail) => 1 + length(tail)
        // (_, ys)
            // _ is when you ignore the head of the list
            // ys is the tail of the list (everything after the head)
        // 1 + length(ys)
            // recursive length; add 1 for each iteration
            // 1 is current head
            // length(ys) is the tail

    }
}

/*
def length [X] (xs: MyList[X]) : Int = {
    xs match {
        case MyNil => 0;
        // case (y:ys) => 1 + length(ys);
        case MyCons(_, ys) => 1 + length(ys);
    }
}
*/

def toList [X] (xs:MyList[X]) : List[X] = {
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

/*
def toList [X] (xs: MyList[X]): List[X] = {
    xs match {
        case MyNil => Nil; // don't forget to return Nil because it's a list and not an int type!
        case MyCons(y, ys) => y::toList(ys);
        // if its a cons it unrolls it by prepending
    }
}

def fromList [X] (xs: List[X]): MyList[X] = {
    xs match {
        case MyNil => Nil;
        case y:ys => MyCons (y, fromList(ys));
        // as its normal it rolls it by recursively calling cons (head, mylist(tail));
    }
}
*/


// MyList to list
def toList [X] (xs: MyList[X]): List[X] = {
    xs match {
        case MyNil => Nil;
        case MyCons(head, tail) => head :: toList(tail);
    }
}

// list to MyList
def fromList [X] (xs: List[X]): MyList[X] = {
    xs match {
        case Nil => MyNil;
        case head :: tail => MyCons(head, fromList(tail));
    }
}

// SWAP EVERYTHING FROM MYLIST TO LIST AND VICE VERSA

/*
// connect two lists
def append [X] (xs:MyList[X], ys:MyList[X]) : MyList[X] = {
    xs match {
        case MyNil => ys;
        // at its base it returns the last element of the 2nd list ys
        case MyCons(z, zs) => MyCons(z, append(zs, ys))
                            // the MyCons creates a new list
                            // Each time MyCons(z, append(zs, ys)) is executed, it constructs a new instance of the MyList type. 
                            // Goes to base ys and then appends each element of xs backwards one by one.
        // NO: case Nil => MyNil;
        // case MyCons(y, ys) => y ::: append(zs, ys);
    }
}
*/

def append [X] (xs: MyList[X], ys: MyList[X]): MyList[X] = {
    xs match {
        case MyNil => ys;
        case MyCons(z, zs) => MyCons(z, append(zs, ys));
    }
}

// your last case must always be something new thats not in the parameters


def map[X,Y] (xs:MyList[X], f:X=>Y): MyList[Y] = {
    xs match {
        case MyNil => MyNil
        case MyCons(y, ys) => MyCons(f(y), map(ys, f));  
                                // you modify each individual element so thats why you do it to the head of each one in f(y)
                                // map(ys, f) calls tail recursively  
                                // f is the 2nd param bc the 2nd param in function def is f
    }
}