package arrays.leetcode

import input.arrays.ReadIntFromConsole

class ReverseInteger {


  fun invoke(x: Int): Int {
    val signMultiplier = if(x < 0) -1 else 1


    val unsignedStr = if(x < 0) x.toString().removePrefix("-") else x.toString()
    var outputString = ""

    println("unsignedStr: $unsignedStr")

    for (i in unsignedStr.length - 1 downTo 0) {
      outputString += unsignedStr[i]
    }

    val outputLong = outputString.toLong()

    return if (outputLong < Int.MIN_VALUE || outputLong > Int.MAX_VALUE) return 0
    else outputLong.toInt() * signMultiplier
  }

}


//-2147483648

fun main() {
  ReadIntFromConsole().invoke()
    .let { ReverseInteger().invoke(it) }
    .let { println("OUTPUT: $it") }
}
