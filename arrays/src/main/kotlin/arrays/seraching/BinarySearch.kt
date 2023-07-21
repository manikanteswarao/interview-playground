package arrays.seraching

import arrays.sorting.IsSortedArray
import arrays.input.ReadIntArrayFromConsole

class BinarySearch {

  // return index
  fun invoke(input: IntArray, element: Int): Int? {
    require(IsSortedArray().invoke(input)) { "Array should be sorted" }
    return binarySearch(input, 0, input.size, element)
  }

  private fun binarySearch(input: IntArray, leftIndex: Int, rightIndex: Int, element: Int): Int? {
    if (leftIndex < 0 || rightIndex > input.size || leftIndex > rightIndex) return null

    val midIndex = (leftIndex + rightIndex - 1) / 2

    return when {
      element == input[midIndex] -> midIndex
      element < input[midIndex] -> binarySearch(input, leftIndex, midIndex - 1, element)
      else -> binarySearch(input, midIndex + 1, rightIndex, element)
    }
  }
}


fun main() {
  val input = ReadIntArrayFromConsole().invoke()
  println("Please enter element to be searched")
  val element = readLine()!!.toInt()
  val index = BinarySearch().invoke(input, element)

  println("Given element is found at the index: $index")
}
