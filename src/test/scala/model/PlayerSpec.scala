package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec extends AnyWordSpec with Matchers{
  "A player" when {
    "new" should {
      val player = Player("Your name", 1, 9)
      "have a name" in {
        player.name should be("Your name")
      }
      "have a color" in {
        player.color should be(1)
      }
      "have max stones" in {
        player.MAX_STONES should be(9)
      }
    }
  }
}
