package model

import controller.Controller
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class MaybeInputSpec extends AnyWordSpec with Matchers{
  "An Input" when {
    "new" should {
      val board = new Board
      val controller = new Controller(board, Vector())
      "check if the input length is two" in {
        MaybeInput(Some("IN")).validLength.input should be(Some("IN"))
        MaybeInput(Some("TOO LONG")).validLength.input should be(None)
        MaybeInput(None).validLength.input should be(None)
      }
      "check if the input consists of digits" in {
        MaybeInput(Some("123")).validInt.input should be(Some("123"))
        MaybeInput(Some("NaN")).validInt.input should be(None)
        MaybeInput(None).validInt.input should be(None)
      }
      "check if coordinates are valid and provide List[int]" in {
        MaybeInput(Some("11")).validCoordinates.input should be(Some(List(1, 1)))
        MaybeInput(Some("00")).validCoordinates.input should be(None)
        MaybeInput(Some("01")).validCoordinates.input should be(None)
        MaybeInput(Some("10")).validCoordinates.input should be(None)
        MaybeInput(Some("41")).validCoordinates.input should be(None)
        MaybeInput(Some("19")).validCoordinates.input should be(None)
        MaybeInput(Some("99")).validCoordinates.input should be(None)
        MaybeInput(None).validCoordinates.input should be(None)
      }
      "check if stone is already set in board" in {
        MaybeInput(Some(List(1, 1))).validateStone(controller.board).input should be(Some(List(1, 1)))
        controller.setStone(0, 0, 1)
        MaybeInput(Some(List(1, 1))).validateStone(controller.board).input should be(None)
        MaybeInput(None).validateStone(controller.board).input should be(None)
      }
    }
  }
}
