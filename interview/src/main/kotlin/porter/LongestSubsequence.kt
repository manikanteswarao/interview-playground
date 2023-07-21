package porter

import input.arrays.ReadIntArrayFromConsole

/*

  Given a sequence of 0s and 1s find the maximum length subsequence of continuous 1s.
  And return the starting and end position.
  If I give you the option to replace any 0 with 1 then which position of 0 you will replace to
  generate the maximum length subsequence of continuous 1s.
  And what will be max length.
  Also what will be the range (starting and end position) of that subsequence.
 */



class LongestSubsequence {

  private data class Result(
    var globalLongest: Int = 0,
    var currentLongest: Int = 0
  )

  fun invoke(input: IntArray): Int {
    var result = Result()
    for (element in input) result = compare(element, result)
    return result.globalLongest
  }

  private fun compare(currentElement: Int, result: Result): Result {
    if (currentElement == 1) result.currentLongest += 1
    result.globalLongest = maxOf(result.currentLongest, result.globalLongest)
    if (currentElement == 0) result.currentLongest = 0
    return result
  }
}

class LongestSubsequenceWithReplacement {
  private data class Result(
    val index: Int,
    var adjacent: Int
  )

  fun invoke(input: IntArray): Int {
    val results = computeResults(input)
    val result = results.maxBy { it.adjacent }
    return result!!.index
  }

  private fun computeResults(input: IntArray): List<Result> {
    val results = mutableListOf<Result>()

    var leftSide = 0
    input.forEachIndexed { index, element ->
      if (element == 0) {
        if (results.lastOrNull() != null) results.last().adjacent += leftSide
        results.add(Result(index, leftSide))
        leftSide = 0
      } else leftSide += 1
    }
    results.last().adjacent += leftSide
    return results
  }
}


fun main() {
  val input = ReadIntArrayFromConsole().invoke()
  val result = LongestSubsequenceWithReplacement().invoke(input)
  println("Result is: $result")
}

