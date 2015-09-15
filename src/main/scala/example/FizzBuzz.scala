package example

object FizzBuzz extends Enhancements {

  def process(numbers: List[Int]): String = numbers.map(replace).mkString(" ")

  def replace(n: Int) = n match {
    case x if x.contains("3") => "lucky"
    case x if x.isMultipleOf(15) => "fizzbuzz"
    case x if x.isMultipleOf(5) => "buzz"
    case x if x.isMultipleOf(3) => "fizz"
    case _ => n.toString
  }
}
