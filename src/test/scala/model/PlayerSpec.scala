package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class PlayerSpec extends AnyWordSpec with Matchers{
  "The function create_player" should{
    "create a player with name and color" in {
      val name = "Feli"
      val color = 1
      val new_player = new Player(name, color).create_player()
      val return_player = new Player("Feli", 1)
      new_player should be(return_player)
    }
  }

class PlayerSpec extends AnyWordSpec with Matchers{
  "A player" when {
    "new" should {
      val player = Player("Your name", 1)
      "have a name" in {
        player.name should be("Your name")
      }
      "have a color" in {
        player.color should be(1)
      }
    }
  }
}
