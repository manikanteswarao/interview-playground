package dp

import input.arrays.ReadStringArrayFromConsole

class LongestCommonPrefix {

  fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.isEmpty()) return ""

    var commonStr = strs.first()

    for (i in 1 until strs.size) {
      commonStr = findCommon(commonStr, strs[i])
      if (commonStr.isEmpty()) return ""
    }

    return commonStr
  }

  fun findCommon(s1: String, s2: String): String {
    val len1 = s1.length
    val len2 = s2.length
    val minSize = minOf(len1, len2)

    var index = 0
    while (index < minSize && s1[index] == s2[index]) index++

    return s1.substring(0, index)
  }
}


fun main1() {
  ReadStringArrayFromConsole().invoke()
    .let { LongestCommonPrefix().longestCommonPrefix(it) }
    .let { println("Answer is: $it") }
}
