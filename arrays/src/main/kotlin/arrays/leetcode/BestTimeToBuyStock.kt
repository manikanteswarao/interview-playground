package arrays.leetcode

import input.arrays.ReadIntArrayFromConsole

private class BestTimeToBuyStock {

  fun maxProfit(prices: IntArray): Int {
    val size = prices.size

    var buy = 0
    var sell = 1
    var maxProfit = 0

    while (sell < size) {
      val currentProfit = prices[sell] - prices[buy]
      if (currentProfit > maxProfit) maxProfit = currentProfit
      if (prices[sell] < prices[buy]) buy = sell
      sell++
    }

    return maxProfit
  }
}

fun main() {
  ReadIntArrayFromConsole().invoke()
    .let { BestTimeToBuyStock().maxProfit(it) }
    .let { println("Answer is: $it") }
}