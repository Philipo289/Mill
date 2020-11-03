package controller

import model.Board
import controller.Controller
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  val controller = new Controller
  "The function create_new_board" should {
    "call the function create_board of class Board" in {
      val return_board = new Board().create_Board()
      controller.create_new_Board() should be(return_board)
    }
  }
  "The function create_new_player" should {
    "return a string of class player" in {
      val return_string = "Feli1"
      val name = "Feli"
      val color= 1
      controller.create_new_Player(name, color) should be(return_string)
    }
  }
  "The function check_color" should{
    "return string 'white' to color int" in{
      val color_1 = 1
      controller.check_color(color_1) should be("white")
    }
    "return string 'black' to color int" in{
      val color_2 = 2
      controller.check_color(color_2) should be("black")
    }
    "return nothing" in{
      val color_3 = 3
      controller.check_color(color_3) should be("Invalid color value!")
    }
  }
}
