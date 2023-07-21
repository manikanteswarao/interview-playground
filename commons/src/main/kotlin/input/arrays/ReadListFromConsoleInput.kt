package input.arrays

class ReadListFromConsoleInput {

  fun invoke(): List<Int> {
    println("Hello! Enter the array elements with spaces and then press enter...")
    return readLine()!!
      .split(" ")
      .filterNot { it.length < 1 }
      .map(String::toInt)
  }
}
