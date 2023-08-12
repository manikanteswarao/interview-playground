import `in`.mani.interview.ShipItDecider
import org.amshove.kluent.shouldBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class ShipItDeciderTest : Spek({


  describe("voting test") {
    val useCase = ShipItDecider()

    val ballots = listOf(
      ShipItDecider.Ballot(listOf("A", "B", "C")),
      ShipItDecider.Ballot(listOf("B", "A", "D"))
    )

    it("first test") {

      useCase.invoke(ballots) shouldBeEqualTo listOf("A", "B", "D", "C")
    }
  }
})