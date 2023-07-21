import input.arrays.ReadStringFromConsole

class RomanToInteger {

  fun invoke(s: String): Int {

    val map: Map<Char, Int> =
      mapOf(
        'M' to 1000,
        'D' to 500,
        'C' to 100,
        'L' to 50,
        'X' to 10,
        'V' to 5,
        'I' to 1
      )

    val inputArray = s.toCharArray()
    val size = s.length
    var number = 0
    for (index in inputArray.indices) {
      if (index + 1 < size && map.getValue(inputArray[index]) < map.getValue(inputArray[index + 1])) {
        number -= map.getValue(inputArray[index])
      } else
        number += map.getValue(inputArray[index])
    }
    return number
  }
}

fun main() {
  ReadStringFromConsole().invoke()
    .let { RomanToInteger().invoke(it) }
    .let { println("Answer is: $it") }
}

