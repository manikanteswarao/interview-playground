package input.arrays

class ReadIntFromConsole {

  fun invoke(): Int {
    println("Hello! Enter the Integer and then press enter...")
    return readLine()!!.toInt()
  }

}