package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class BoardSpec extends AnyWordSpec with Matchers{

  "The function create_board" should {
    "creates a Vector[Vector[Int]] with 3 x 8 points" in {

      val return_should_be_board = Vector(Vector(0, 0, 0, 0, 0, 0, 0, 0), Vector(0, 0, 0, 0, 0, 0, 0, 0), Vector(0, 0, 0, 0, 0, 0, 0, 0))
      val test_board = new Board().create_Board()
      test_board should be(return_should_be_board)
    }
  }
  "The function update_Board" should{
    "updates one value of an existing board at a given position (rectangle, position, value)" in{
      val existing_board = Vector(Vector(0, 1, 2, 3, 4, 5, 6, 7), Vector(8, 9, 10, 11, 12, 13, 14, 15), Vector(16, 17, 18, 19, 20, 21, 22, 23))
      val rectangle_num = 1
      val position = 0
      val value = 55
      val updated_board = new Board().update_board(rectangle_num, position, value, existing_board)
      val return_board = Vector(Vector(0, 1, 2, 3, 4, 5, 6, 7), Vector(55, 9, 10, 11, 12, 13, 14, 15), Vector(16, 17, 18, 19, 20, 21, 22, 23))
      updated_board should be(return_board)
    }
      
  }



}
