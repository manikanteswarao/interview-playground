import input.arrays.ReadStringArrayFromConsole

//https://leetcode.com/problems/longest-common-prefix/


class LongestCommonPrefix {


  fun invoke(strs: Array<String>): String {
    if (strs.isEmpty()) return ""



    TODO()
  }
}

fun main() {

  ReadStringArrayFromConsole().invoke()
    .let { LongestCommonPrefix().invoke(it) }
    .let { println("Answer is: $it") }
}
