import input.arrays.ReadIntArrayFromConsole

class TwoSum {

  fun invoke(nums: IntArray, target: Int): IntArray {
    val sortedArray: IntArray = nums.sortedArray()

    var leftIndex = 0
    var rightIndex = nums.size - 1

    while (leftIndex < rightIndex) {
      val leftElement = sortedArray[leftIndex]
      val rightElement = sortedArray[rightIndex]
      val sum = leftElement + rightElement

      if (sum == target) {
        return if (leftElement == rightElement) intArrayOf(
          nums.indexOfFirst { it == leftElement },
          nums.indexOfLast { it == rightElement })
        else intArrayOf(nums.indexOf(leftElement), nums.indexOf(rightElement))
      }

      if (sum < target) leftIndex++
      else rightIndex--
    }

    return intArrayOf(0, 0)
  }
}

fun main() {
  val intArray = ReadIntArrayFromConsole().invoke()

  val target = ReadIntArrayFromConsole().invoke()

  TwoSum().invoke(intArray, target.first())
    .let { it.joinToString(",") }
    .let { println("Answer is: $it") }
}

