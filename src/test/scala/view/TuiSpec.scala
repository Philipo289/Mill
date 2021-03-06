package view

import controller.Controller
import model.{Board, Player, Stone}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class TuiSpec extends AnyWordSpec with Matchers{

  "A Mill Tui" should{
    val controller = new Controller(new Board, Vector())
    controller.create_new_Players("PlayerOne", "PlayerTwo")
    val tui = new Tui(controller)
    "create a new board on input 'n'" in{
      tui.processInputLine("n")
      controller.board should be(new Board)
    }
    "should do nothing and leave loop on input 'q'" in {
      tui.processInputLine("q")
    }
    "should print the help board on input 'h'" in {
      tui.processInputLine("h")
    }
    "should provide any other input" in {
      tui.processInputLine("*")
    }

    "should do nothing and leave loop in input 'q' in game mode" in {
      tui.processGameInputLine("q")
    }
    "should print the help board on input 'h' in game mode" in {
      tui.processGameInputLine("h")
    }

    "should provide a welcome screen" in {
      val welcomeScreen =
        "**********************************************************************************************\n" +
        "*                                       WELCOME TO                                           *\n"   +
        "*  __________   __     __   ________      _____      ______    __    __           __         *\n"   +
        "* |___    ___| |  |   |  | |   _____|    |   _  \\   /  _   |  |  |  |  |         |  |        *\n"  +
        "*     |  |     |  |___|  | |  |_____     |  | \\  \\_/  / |  |  |  |  |  |         |  |        *\n" +
        "*     |  |     |   ___   | |  ______|    |  |  \\_____/  |  |  |  |  |  |         |  |        *\n"  +
        "*     |  |     |  |   |  | |  |_____     |  |           |  |  |  |  |  |______   |  |______  *\n"   +
        "*     |__|     |__|   |__| |________|    |__|           |__|  |__|  |_________|  |_________| *\n"   +
        "*                                        IN SCALA                                            *\n"   +
        "**********************************************************************************************\n"   +
        "Press 'n' for new Game\nPress 'h' for help\nPress 'q' to quit\n"
      tui.welcomeScreen() should be(welcomeScreen)
    }
    "should provide a goodbye screen" in {
      val goodbyeScreen =
        "**********************************************************************************************\n" +
        "*                                  THANK YOU FOR PLAYING                                     *\n"   +
        "*  __________   __     __   ________      _____      ______    __    __           __         *\n"   +
        "* |___    ___| |  |   |  | |   _____|    |   _  \\   /  _   |  |  |  |  |         |  |        *\n"  +
        "*     |  |     |  |___|  | |  |_____     |  | \\  \\_/  / |  |  |  |  |  |         |  |        *\n" +
        "*     |  |     |   ___   | |  ______|    |  |  \\_____/  |  |  |  |  |  |         |  |        *\n"  +
        "*     |  |     |  |   |  | |  |_____     |  |           |  |  |  |  |  |______   |  |______  *\n"   +
        "*     |__|     |__|   |__| |________|    |__|           |__|  |__|  |_________|  |_________| *\n"   +
        "*                                        IN SCALA                                            *\n"   +
        "**********************************************************************************************\n"
      tui.goodbyeScreen() should be(goodbyeScreen)
    }
    "should provide a help board" in {
      val helpBoard =
        "To access the Nodes see the following coordinates:\n" +
        "               O----------------------------O----------------------------O\n" +
        "               | (11)                       | (12)                  (13) |\n" +
        "               |                            |                            |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |          | (21)            | (22)       (23) |          |\n" +
        "               |          |            (32) |                 |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |         | (31)     (33) |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               O----------O---------O (38)     (34) O---------O----------O\n" +
        "               | (18)     | (28)    |               |    (24) |     (14) |\n" +
        "               |          |         | (37)     (35) |         |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |            (36) |                 |          |\n" +
        "               |          | (27)            | (26)       (25) |          |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |                            |                            |\n" +
        "               | (17)                       | (16)                  (15) |\n" +
        "               O----------------------------O----------------------------O\n"
      tui.helpBoard() should be(helpBoard)
    }
    "should provide a player one name input" in {
      val playerOneInput = "Please enter name of player one: "
      tui.playerOneName() should be(playerOneInput)
    }
    "should provide a player two name input" in {
      val playerTwoInput = "Please enter name of player two: "
      tui.playerTwoName() should be(playerTwoInput)
    }
    "should provide a Game-Phase-One phrase" in {
      val gpOne = "Let the game begin.\nGame Phase One: Please place your stones on a free field."
      tui.gamePhaseOneBegin() should be(gpOne)
    }
    "should provide a Game-Phase-Two phrase" in {
      val gpTwo = "Game Phase Two: Move your Stones strategically and get the victory."
      tui.gamePhaseTwoBegin() should be(gpTwo)
    }
    "should provide a warning if wrong coordinates were used" in {
      val warningMsg = "Invalid coordinates entered.\nPlease select another free coordinates."
      tui.coordinationWarning() should be(warningMsg)
    }
    "should provide a warning if stone position is already used" in {
      val warningMsg = "Stone location already used.\nPlease select another free coordinates."
      tui.stoneWarning() should be(warningMsg)
    }
    "should provide a message to show which player is playing with the amount of stones played" in {
      tui.currentPlayer = new Player("Your Name", 1, 9)
      val playerMsg = "\nYour Name it is your turn Place one stone on a specific coordinate (1 of 9):"
      tui.playerGamePhaseOneTurns() should be(playerMsg)
    }
    "should update the board with new stones" in {
      val emptyBoard = new Board
      val filledPlayerOneBoard = emptyBoard.update_board(0, 0, 1)
      val filledPlayerTwoBoard = emptyBoard.update_board(0, 0, 2)

      val emptyBoardString =
        "               O----------------------------O----------------------------O\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               O----------O---------O               O---------O----------O\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               O----------------------------O----------------------------O\n"
      val filledPlayerOneBoardString =
        "               W----------------------------O----------------------------O\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               O----------O---------O               O---------O----------O\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               O----------------------------O----------------------------O\n"
      val filledPlayerTwoBoardString =
        "               B----------------------------O----------------------------O\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               O----------O---------O               O---------O----------O\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         |               |         |          |\n" +
        "               |          |         O-------O-------O         |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          |                 |                 |          |\n" +
        "               |          O-----------------O-----------------O          |\n" +
        "               |                            |                            |\n" +
        "               |                            |                            |\n" +
        "               O----------------------------O----------------------------O\n"
      tui.updateBoard(emptyBoard) should be(emptyBoardString)
      tui.updateBoard(filledPlayerOneBoard) should be(filledPlayerOneBoardString)
      tui.updateBoard(filledPlayerTwoBoard) should be(filledPlayerTwoBoardString)
    }
  }
}
