package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class StoneSpec extends AnyWordSpec with Matchers{
    "A Stone" when {
      "not set to any color" should {
        val emptyStone = Stone(0, false)
        "have value 0" in {
          emptyStone.color should be(0)
        }
        "not be set" in {
          emptyStone.isSet should be(false)
        }
      }
      "set to specific color" should {
        val playerStone = Stone(1, false)
        "return that color" in {
          playerStone.color should be(1)
        }
        "be set" in {
          playerStone.isSet should be(true)
        }
      }
    }
}
