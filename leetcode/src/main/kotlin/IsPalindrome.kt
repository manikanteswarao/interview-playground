import input.arrays.ReadIntFromConsole

class IsPalindrome {


  fun invoke(x: Int): Boolean {
    val inputStr =  x.toString()
    val size = inputStr.length

    var leftIndex = 0
    var rightIndex = size -1

    while (leftIndex < rightIndex) {
      if(inputStr[leftIndex] != inputStr[rightIndex]) return false
      leftIndex++
      rightIndex--
    }

    return true
  }
}

fun main() {
  ReadIntFromConsole().invoke()
    .let { IsPalindrome().invoke(it) }
    .let { println("Answer: $it") }
}