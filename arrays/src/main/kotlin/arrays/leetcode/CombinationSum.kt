package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

class CombinationSum {

  val output: MutableList<List<Int>> = mutableListOf()

  fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    find(candidates, target, mutableListOf(), 0)
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
        val newSumList = sumList + listOf(element)
        find(candidates, sum - element, newSumList, index)
      }
    }

  }
}


fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { CombinationSum().combinationSum(it, 1) }
    .map { println(it) }
}