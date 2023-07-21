package dp

//https://leetcode.com/problems/longest-consecutive-sequence

private class LongestConsecutiveSequence {

  fun longestConsecutive(nums: IntArray): Int {
    val set = hashSetOf<Int>()
    for (element in nums) set.add(element)

    var best = 0

    for (n in set) {
      if (!set.contains(n - 1)) {
        var m = n + 1
        while (set.contains(m)) m++
        best = maxOf(best, m - n)
      }

    }

    return best
  }
}

fun main() {
  intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)
    .let { LongestConsecutiveSequence().longestConsecutive(it) }
    .let { println("Answer is: $it") }
}
