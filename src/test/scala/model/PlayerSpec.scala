package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PlayerSpec extends AnyWordSpec with Matchers{
  "A player" when {
    "new" should {
      val player = Player("Your name", 1)
      "have a name" in {
        player.name should be("Your name")
      }
      "have a color" in {
        player.color_Int should be(1)
      }
    }
  }
}
