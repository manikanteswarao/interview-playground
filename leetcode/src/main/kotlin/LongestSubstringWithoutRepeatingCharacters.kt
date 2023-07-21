import input.arrays.ReadStringFromConsole

class LongestSubstringWithoutRepeatingCharacters {


  fun invoke(s: String): Int {
    if (s.isEmpty()) return 0
    var globalMax = 0

    var visited: MutableMap<Char, Int> = mutableMapOf()
    var windowStart = 0
    var windowEnd = 0

    for (i in s.indices) {
      val currentChar = s[i]

      if (visited.containsKey(currentChar)) {
        windowStart = maxOf(visited[currentChar]!! + 1, windowStart)
      }
      windowEnd = i
      visited[currentChar] = i
      if (globalMax < windowEnd - windowStart) globalMax = windowEnd - windowStart

    }

    return globalMax + 1
  }
}

fun main() {
  ReadStringFromConsole().invoke()
    .let { LongestSubstringWithoutRepeatingCharacters().invoke(it) }
    .let { println("Answer is: $it") }
}
