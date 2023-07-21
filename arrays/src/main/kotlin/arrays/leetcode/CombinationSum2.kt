package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

//https://leetcode.com/problems/combination-sum-ii/

class CombinationSum2 {

  val output: MutableList<List<Int>> = mutableListOf()

  fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    find(candidates, target, emptyList(), 0)
    return output
  }

  private fun find(candidates: IntArray, sum: Int, sumList: List<Int>, currentIndex: Int) {
    if (sum == 0) {
      output.add(sumList)
      return
    }

    for (index in currentIndex until candidates.size) {
      val element = candidates[index]

      if (element <= sum) {
        val newList = sumList + listOf(element)
        find(candidates, sum - element, newList, index + 1)
      }
    }

  }
}


fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { CombinationSum2().combinationSum(it, 5) }
    .map { println(it) }
}
