import input.arrays.ReadIntArrayFromConsole
import kotlin.math.floor

class MedianOfTwoSortedArrays {


  fun invoke(nums1: IntArray, nums2: IntArray): Double {

    val firstArraySize = nums1.size
    val secondArraySize = nums2.size

    val mergedArray = (nums1 + nums2).sortedArray()
    val mergedArraySize = firstArraySize + secondArraySize

    if(mergedArraySize % 2 == 0) {
      val x = ((firstArraySize + secondArraySize - 1)/2).toInt()
      val y = ((firstArraySize + secondArraySize + 1)/2).toInt()

      return (mergedArray[x] + mergedArray[y]) * 1.0 /2
    } else {
      val x = ((firstArraySize + secondArraySize)/2).toInt()
      return mergedArray[x] * 1.0
    }
  }

}

fun main() {
  val x = ReadIntArrayFromConsole().invoke()
  val y = ReadIntArrayFromConsole().invoke()

  MedianOfTwoSortedArrays().invoke(x, y)
    .let { println("ANSWER: $it") }
}

