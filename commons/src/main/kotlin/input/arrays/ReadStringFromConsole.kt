package input.arrays

class ReadStringFromConsole {

  fun invoke(): String {
    println("Hello! Enter the String and then press enter...")
    return readLine()!!
  }
}
