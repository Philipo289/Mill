package controller

import model.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import util.Observer

class ControllerSpec extends AnyWordSpec with Matchers{
  "A Controller" when {
    "observed by a Observer" should {
      val board = new Board
      val controller = new Controller(board, Vector())
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated:Boolean = updated
        override def update: Unit = updated = true
      }
      controller.add(observer)
      "notify its Observer after creation" in {
        controller.create_empty_Board()
        observer.updated should be(true)
      }
      "notify its Observer after setting a stone" in {
        controller.setStone(0, 0, 1)
        observer.updated should be(true)
        controller.board.stone(0, 0).color should be(1)
      }
    }
  }
}
