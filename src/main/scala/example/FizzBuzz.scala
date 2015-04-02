package example

object FizzBuzz {

  implicit def addMultipleOfToInt(i: Int): EnhancedInt = new EnhancedInt(i)

  def process(numbers: List[Int]) = numbers.map(replace).mkString(" ")

  def replace(n: Int) = n match {
    case x if x.contains("3") => "lucky"
    case x if x.isMultipleOf(15) => "fizzbuzz"
    case x if x.isMultipleOf(5) => "buzz"
    case x if x.isMultipleOf(3) => "fizz"
    case x => x
  }
}

class EnhancedInt(val x: Int) {
  def isMultipleOf(y: Int): Boolean = x % y == 0
  def contains(s: String): Boolean = x.toString.contains(s)
}
