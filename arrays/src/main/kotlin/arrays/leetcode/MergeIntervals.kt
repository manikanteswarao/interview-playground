package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

//https://leetcode.com/problems/merge-intervals/

class MergeIntervals {


  fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val comparator = kotlin.Comparator<IntArray> { l1, l2 -> l1.first() - l2.first() }
    intervals.sortWith(comparator)

    var output: MutableList<IntArray> = mutableListOf()
    val size = intervals.size

    var index = 1
    var previous = intervals.first()

    while (index < size) {
      val leftInterval = previous
      val rightInterval = intervals[index]

      if (leftInterval.last() >= rightInterval.first()) {
        val newInterval =
          arrayOf(
            minOf(leftInterval.first(), rightInterval.first()),
            maxOf(leftInterval.last(), rightInterval.last())
          ).toIntArray()


        previous = newInterval
      } else {
        output.add(leftInterval)
        previous = rightInterval
      }

      index++
    }
    output.add(previous)
    return output.toTypedArray()
  }

}

fun main() {
  (1..2).map {
    ReadIntArrayFromConsole().invoke()
  }.let { MergeIntervals().merge(it.toTypedArray()) }
    .map { println("Answer is: ${it.map { it }}") }
}