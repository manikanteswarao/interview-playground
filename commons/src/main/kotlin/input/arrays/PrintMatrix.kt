package input.arrays

import kotlin.math.absoluteValue

class PrintMatrix {

  fun <T> invoke(input: Array<Array<T>>) {
    val rows = input.size
    val columns = input.first().size

    print("  ")
    for (i in 0 until columns) {
      print("  $i  ")
    }
    println()
    println("-------------------------------")

    input.forEachIndexed { index, row ->
      print("$index)")
      row.forEach { str ->
        print("  ${str.toString().first()}  ")
      }
      println()
    }
  }


}