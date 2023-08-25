package `in`.mani.interview

import org.amshove.kluent.shouldBeEqualTo
import org.amshove.kluent.shouldNotBeEqualTo
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

class SampleTest : Spek({


  describe("positive") {

    it("should pass") {
      val a = 1
      val b = 1
      a shouldBeEqualTo b
    }

    it("should fail") {
      val a = 1
      val b = 2
      a shouldNotBeEqualTo b
    }
  }
})