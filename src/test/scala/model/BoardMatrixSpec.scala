package model

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BoardMatrixSpec extends AnyWordSpec with Matchers{
  "A BoardMatrix is a tailor-made immutable data type that contains a three-dimensional Vector of Stones. " +
    "A BoardMatrix" when {
      "replace stones and return a new data structure" in {
        val boardMatrix = new BoardMatrix[Stone](Stone(0, false))
        val returnedBoardMatrix = boardMatrix.replaceStone(0, 0, Stone(1, false))
        boardMatrix.stone(0, 0) should be(Stone(0, false))
        returnedBoardMatrix.stone(0, 0) should be(Stone(1, false))
      }
    "show amount of played stones" in {
      val board = new BoardMatrix[Stone](Stone(0, false))
      board.amountOfPlayedStones(0) should be(24)
    }
  }
}
