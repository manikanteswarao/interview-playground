package dp

import input.arrays.ReadIntArrayFromConsole


class MaximumSubArray {


  fun maxSubArray(nums: IntArray): Int {

    var maxSum = Int.MIN_VALUE
    var sumSoFar = 0

    for (value in nums) {
      sumSoFar += value
      if (sumSoFar > maxSum) maxSum = sumSoFar
      if (sumSoFar < 0) sumSoFar = 0
    }

    return maxSum
  }


}


fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { MaximumSubArray().maxSubArray(it) }
    .let { println("Answer is: $it") }
}
