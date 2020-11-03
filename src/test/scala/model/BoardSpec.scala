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


class BoardSpec extends AnyWordSpec with Matchers{
  "A board" when {
    "created properly but empty" should {
      val board = new Board
      "give access to its Stones" in {
        board.stone(0, 0) should be(Stone(0))
        board.stone(0, 1) should be(Stone(0))
        board.stone(0, 2) should be(Stone(0))
        board.stone(0, 3) should be(Stone(0))
        board.stone(0, 4) should be(Stone(0))
        board.stone(0, 5) should be(Stone(0))
        board.stone(0, 6) should be(Stone(0))
        board.stone(0, 7) should be(Stone(0))
        board.stone(1, 0) should be(Stone(0))
        board.stone(1, 1) should be(Stone(0))
        board.stone(1, 2) should be(Stone(0))
        board.stone(1, 3) should be(Stone(0))
        board.stone(1, 4) should be(Stone(0))
        board.stone(1, 5) should be(Stone(0))
        board.stone(1, 6) should be(Stone(0))
        board.stone(1, 7) should be(Stone(0))
        board.stone(2, 0) should be(Stone(0))
        board.stone(2, 1) should be(Stone(0))
        board.stone(2, 2) should be(Stone(0))
        board.stone(2, 3) should be(Stone(0))
        board.stone(2, 4) should be(Stone(0))
        board.stone(2, 5) should be(Stone(0))
        board.stone(2, 6) should be(Stone(0))
        board.stone(2, 7) should be(Stone(0))
      }
      "allow to set individual Stones and remain immutable" in {
        val changedBoard = board.update_board(0, 0, 1)
        changedBoard.stone(0, 0) should be(Stone(1))
        board.stone(0, 0) should be(Stone(0))
      }
      "allow to check individual Stones if set" in {
        val changedBoard = board.update_board(0, 0, 1)
        board.check_stone_Set(0, 0) should be(false)
        changedBoard.check_stone_Set(0, 0) should be(true)
      }
      "get amount of played stones depending on a specific color" in {
        val changedBoard = board.update_board(0, 0, 1)
        board.amount_of_played_stones(0) should be(24)
        changedBoard.amount_of_played_stones(1) should be(1)
      }
    }
  }
}
