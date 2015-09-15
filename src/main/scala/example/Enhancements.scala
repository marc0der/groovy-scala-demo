package example

trait Enhancements {

  implicit class EnhancedInt(val x: Int) {
    def isMultipleOf(y: Int): Boolean = x % y == 0

    def contains(s: String): Boolean = x.toString.contains(s)
  }

}
