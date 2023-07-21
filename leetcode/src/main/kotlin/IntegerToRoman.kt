import input.arrays.ReadIntFromConsole

class IntegerToRoman {


  fun invoke(num: Int): String {
    var input = num
    val normal = arrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val roman = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var res = ""
    for (i in 0..12) {
      while (input >= normal[i]) {
        res += roman[i]
        input -= normal[i]
      }
    }
    return res
  }


}

fun main() {
  ReadIntFromConsole().invoke()
    .let { IntegerToRoman().invoke(it) }
    .let { "Answer is: $it"}
}