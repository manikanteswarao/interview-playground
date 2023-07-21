package input.arrays

class ReadStringArrayFromConsole {

  fun invoke(): Array<String> {
    println("Hello! Enter the array elements with spaces and then press enter...")
    return readLine()!!
      .split(" ")
      .filterNot { it.isEmpty() }
      .map(String::toString)
      .toTypedArray()
  }
}