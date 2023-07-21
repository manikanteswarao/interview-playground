package input.arrays

class ReadIntArrayFromConsole {

  fun invoke(): IntArray {
    println("Please enter the input array elements separated by space")

    return readLine()!!
      .split(" ")
      .filterNot { it.isEmpty() }
      .map(String::toInt)
      .toIntArray()
  }
}
