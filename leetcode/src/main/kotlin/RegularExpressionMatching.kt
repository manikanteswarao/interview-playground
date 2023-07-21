import input.arrays.ReadStringFromConsole

//https://leetcode.com/problems/regular-expression-matching/

class RegularExpressionMatching {
  companion object {
    private const val ANY_CHAR_MATCH = '.'
    private const val MULTI_CHAR_MATCH = '*'
  }


  fun isMatch(s: String, p: String): Boolean {
    TODO()
  }
}


fun main() {
  val input = ReadStringFromConsole().invoke()
  val pattern = ReadStringFromConsole().invoke()

  RegularExpressionMatching().isMatch(input, pattern)
    .let { println("ANSWER: $it") }
}
