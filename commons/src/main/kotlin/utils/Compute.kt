package utils

import kotlin.math.round


class Compute {


  fun invoke(amountInLakhs: Double, interestRate: Int) {

    val lakhOrder = 100000

    var newAmount = amountInLakhs * lakhOrder

    repeat(5) { it: Int ->

      newAmount += (newAmount * 0.01 * interestRate * 12)

      val humanFormat = (newAmount/lakhOrder).roundCustom(1)
      println("Money after ${it + 1} year: $humanFormat L")

    }

  }


}


fun main() {
  Compute().invoke(10.0, 2)
}

 fun Double.roundCustom(decimals: Int): Double {
  var multiplier = 1.0
  repeat(decimals) { multiplier *= 10 }
  return round(this * multiplier) / multiplier
}
