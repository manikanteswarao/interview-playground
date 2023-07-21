package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

//https://leetcode.com/problems/jump-game/

class JumpGame {

  fun canJump(nums: IntArray): Boolean {

    val size = nums.size
    val canJump = Array<Boolean>(size) { false }
    canJump[0] = true

    for (index in nums.indices) {
      if (!canJump[index]) return false

      for (j in index..index + nums[index]) {
        if (j < size) canJump[j] = true
      }
    }

    return canJump[size - 1]
  }

}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { JumpGame().canJump(it) }
    .let { println("Answer is: $it") }
}
