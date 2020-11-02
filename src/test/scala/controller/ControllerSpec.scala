package controller

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers{
  val board = new Board
  val controller = new Controller(board)
  val rectangle_num = 0
  val position = 0
  val stone = 1
  val rectangle_num_new = 1
  val position_new= 1
  val reset_stone = 0
  "The function move_stone" should{
    "return true if successful" in{

      controller.move_stone(rectangle_num, position, stone, rectangle_num_new, position_new) should be (true)
    }
    "The function select_stone" should{
      "return true if successful" in{

        controller.select_stone(rectangle_num, position, stone) should be(true)
      }
      "return false if not successful" in{

        controller.select_stone(rectangle_num, position, stone) should be(false)
      }

    }
  }

}