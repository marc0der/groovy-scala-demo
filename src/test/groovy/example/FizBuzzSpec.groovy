package example

import spock.lang.Specification

import static scala.collection.JavaConversions.asScalaIterator

class FizBuzzSpec extends Specification {

    def range

    void setup() {
        range = scalaCollection(1..20)
    }

    void "should return the number for contiguous range"() {
        expect:
        def result = FizzBuzz.process(range)
        expectAt(result, word, position)

        where:
        word    |   position
        "1"     |   1
        "2"     |   2
        "4"     |   4
        "7"     |   7
        "8"     |   8
        "11"    |   11
        "14"    |   14
        "16"    |   16
        "17"    |   17
        "19"    |   19
    }

    void "should return fizz for numbers that are multiples of 3"() {
        expect:
        def result = FizzBuzz.process(range)
        expectAt(result, word, position)

        where:
        word    |   position
        "fizz"  |   6
        "fizz"  |   9
        "fizz"  |   12
    }

    void "should return buzz for numbers that are multiples of 5"() {
        expect:
        def result = FizzBuzz.process(range)
        expectAt(result, word, position)

        where:
        word    |   position
        "buzz"  |   5
        "buzz"  |   10
    }

    void "should return fizzbuzz for numbers that are multiples of 15"() {
        expect:
        def result = FizzBuzz.process(range)
        expectAt(result, word, position)

        where:
        word        |   position
        "fizzbuzz"  |   15
    }

    void "should return lucky for numbers containing 3"() {
        expect:
        def result = FizzBuzz.process(range)
        expectAt(result, "lucky", position)

        where:
        word    |   position
        "lucky" |   3
        "lucky" |   13
    }

    private static scalaCollection(range) {
        asScalaIterator(range.iterator()).toList()
    }

    private static expectAt(String fizzBuzz, String word, int postition) {
        fizzBuzz.tokenize().get(postition - 1) == word
    }

}
