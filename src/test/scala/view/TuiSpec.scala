package view

import controller.Controller
import model.Board
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class TuiSpec extends AnyWordSpec with Matchers{

  "A Mill Tui" should{
    val controller = new Controller(new Board(24))
    val tui = new Tui(controller)
    "create a new board on input 'n'" in{
      tui.processInputLine("n")
      controller.board should be(new Board(24))
    }
  }
}
