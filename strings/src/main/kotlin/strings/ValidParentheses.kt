package strings

//https://leetcode.com/problems/valid-parentheses/

private class ValidParentheses {

  fun isValid(s: String): Boolean {
    val stack: ArrayDeque<Char> = ArrayDeque()

    for (element in s) {
      when (element) {
        '(', '{', '[' -> stack.addLast(element)
        else -> {

          if(stack.isEmpty()) return false
          val pop = stack.removeLast()

          if(element == ')') if(pop != '(') return false
          if(element == '}') if(pop != '{') return false
          if(element == ']') if(pop != '[') return false
        }
      }
    }

    return stack.isEmpty()
  }

}

fun main() {
  ValidParentheses().isValid("{[]}")
    .let { println("Answer is: $it") }
}
