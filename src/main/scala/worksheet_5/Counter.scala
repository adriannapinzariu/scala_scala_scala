// 2.1 Java to Scala
/*
class Counter {
  private static int numCounters = 0;

  final int id;
  int count;

  Counter (int initial) {
    this.id = numCounters;
    this.count = initial;
    numCounters++;
  }

  static int getNumCounters () {
    return numCounters;
  }

  int getId () {
    return this.id;
  }

  int getNextCount () {
    return this.count++;
  }
}
*/


/*
// this is basically the constructor
object Counter {
    private var numCounters = 0 // field
    def getNumCounters () : Int = numCounters // method
    def incNumCounters () : Unit = numCounters = numCounters + 1 // method
}

class Counter (initial:Int) { 
  // the parameters here should be the same ones as the Java constructor would have
    private val id: Int = Counter.getNumCounters() // initalize id like in constructor
    private var count: Int = initial // constructor
    Counter.incNumCounters() // increase the number

    def getId(): Int = id
    def getNextCount(): Int = { val tmp = count; count += 1; tmp}
}
*/


object Counter {
  private var numCounters = 0;
  def getNumCounters() : Int = numCounters;
  def incNumCounters() : Unit =  numCounters = numCounters + 1;
}

class Counter (initial:Int) {
  private val id = Counter.getNumCounters();
  private var count = initial;
  Counter.incNumCounters();
  
  def getId() : Int = id;
  def getNextCount() : Int = { val temp = count; count += 1; temp}
}




/*

object Counter {
  private var numCounters = 0;

}
*/