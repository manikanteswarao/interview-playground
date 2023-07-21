package dp

class CoinChange {


  class Recursion {
    companion object {
      private const val NO_SOLUTION = Int.MAX_VALUE - 1
    }

    fun coinChange(coins: IntArray, amount: Int): Int {
      val res = solve(coins, 0, amount)
      return if (res == NO_SOLUTION) -1 else res
    }

    private fun solve(coins: IntArray, index: Int, amount: Int): Int {
      if (index >= coins.size || amount <= 0)
        return if (amount == 0) 0 else NO_SOLUTION

      return if (coins[index] > amount) {
        solve(coins, index + 1, amount)
      } else {
        minOf(
          1 + solve(coins, index + 0, amount - coins[index]), //take this coin
          0 + solve(coins, index + 1, amount - 0) // don't take this coin
        )
      }
    }
  }


  class DPMemoization {

    companion object {
      private const val NO_SOLUTION = Int.MAX_VALUE - 1
    }

    lateinit var dp: Array<IntArray>

    fun coinChange(coins: IntArray, amount: Int): Int {
      dp = Array(coins.size + 1) { IntArray(amount + 1) { -1 } }
      val res = memoization(coins, 0, amount)
      return if (res == NO_SOLUTION) -1 else res
    }

    private fun memoization(coins: IntArray, index: Int, amount: Int): Int {
      if (index == coins.size || amount <= 0)
        return if (amount == 0) 0 else NO_SOLUTION

      if (dp[index][amount] != -1)
        return dp[index][amount]


      if (coins[index] > amount) {
        dp[index][amount] = 0 + memoization(coins, index + 1, amount - 0)
      } else {
        dp[index][amount] = minOf(
          1 + memoization(coins, index + 0, amount - coins[index]),
          0 + memoization(coins, index + 1, amount - 0)
        )
      }

      return dp[index][amount]
    }
  }


}

fun main() {
  val coins = intArrayOf(186, 419, 83, 408)
  val amount = 6249
//  val coins = intArrayOf(1, 2, 5)
//  val amount = 11

  CoinChange.DPMemoization().coinChange(coins, amount)
    .let { println("Answer is: $it") }
}

