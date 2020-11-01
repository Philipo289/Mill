package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BoardSpec extends AnyWordSpec with Matchers{
  "A board" when {
    "created properly but empty" should {
      val board = new Board(24)
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
    }
  }
}
