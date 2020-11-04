package view

import controller.{Controller, GameStatus}
import model.{Board, Player, Stone}
import util.Observer

import scala.io.StdIn.readLine

class Tui(controller: Controller) extends Observer{

  controller.add(this)
  var currentPlayer = new Player("", 0, 0)

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "h" => println(helpBoard())
      case "n" =>
      case _ => println("No valid input. Please try again!")
    }
  }

  def changePlayer(players: Vector[Player]): Player ={
    currentPlayer.color match {
      case 1 => players(1)
      case 2 => players(0)
      case _ => players(0)
    }
  }

  def processGameInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "r" => println("Which stone u want to remove?")
        val input_remove = readLine()
        input_remove match {
        case _ => input_remove.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case rect_num :: pos_num :: Nil => controller.remove_stone((rect_num - 1), (pos_num - 1), 0)
        }
      }
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case rect_num :: pos_num :: Nil => {
            val validCoordinates = controller.checkInputCoordinates(rect_num, pos_num)
            if(validCoordinates) {
              if (controller.gameStatus == GameStatus.GPONE) {
                val validStone = controller.checkStoneSet(rect_num - 1, pos_num - 1)
                if (!validStone) {
                  controller.setStone((rect_num - 1), (pos_num - 1), currentPlayer.color)
                }
                else { println(stoneWarning)
                }
              }
            }
            else{ println(coordinationWarning) }
          }
        }
      }
    }
  }
  def welcomeScreen(): String ={
    val welcomeString = "**********************************************************************************************\n" +
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
    welcomeString
  }

  def playerOneName(): String ={
    val playerString = "Please enter name of player one: "
    playerString
  }
  def playerTwoName(): String ={
    val playerString = "Please enter name of player two: "
    playerString
  }

  def gamePhaseOneBegin(): String = {
    controller.gameStatus = GameStatus.GPONE

    val gpOneString = GameStatus.message(controller.gameStatus)
    gpOneString
  }
  def gamePhaseTwoBegin(): String = {
    controller.gameStatus = GameStatus.GPTWO
    val gpTwoString = GameStatus.message(controller.gameStatus)
    gpTwoString
  }

  def stoneWarning(): String = {
    val warningString = "Stone location already used.\nPlease select another free coordinates."
    warningString
  }
  def coordinationWarning(): String = {
    val warningString = "Invalid coordinates entered.\nPlease select another free coordinates."
    warningString
  }

  def playerInitTurns(): String ={
    val playerTurnString = s"\n${currentPlayer.name} it is your turn Place one stone on a specific coordinate " + "" +
      s"(${controller.amountOfPlayerStones(currentPlayer.color) + 1} of ${currentPlayer.MAX_STONE}):"
    playerTurnString
  }

  def color_matcher(in:Stone):String = {
    in.color match {
      case 0 => "O"
      case 1 => "W"
      case 2 => "B"
    }
  }

  def updateBoard(board: Board): String={
    val uiBoard = board.stones.rows.map(i => i.map(color_matcher))

    val updateString = s"               ${uiBoard(0)(0)}----------------------------${uiBoard(0)(1)}----------------------------${uiBoard(0)(2)}\n" +
    "               |                            |                            |\n" +
    "               |                            |                            |\n" +
    s"               |          ${uiBoard(1)(0)}-----------------${uiBoard(1)(1)}-----------------${uiBoard(1)(2)}          |\n" +
    "               |          |                 |                 |          |\n" +
    "               |          |                 |                 |          |\n" +
    s"               |          |         ${uiBoard(2)(0)}-------${uiBoard(2)(1)}-------${uiBoard(2)(2)}         |          |\n" +
    "               |          |         |               |         |          |\n" +
    "               |          |         |               |         |          |\n" +
    s"               ${uiBoard(0)(7)}----------${uiBoard(1)(7)}---------${uiBoard(2)(7)}               ${uiBoard(2)(3)}---------${uiBoard(1)(3)}----------${uiBoard(0)(3)}\n" +
    "               |          |         |               |         |          |\n" +
    "               |          |         |               |         |          |\n" +
    s"               |          |         ${uiBoard(2)(6)}-------${uiBoard(2)(5)}-------${uiBoard(2)(4)}         |          |\n" +
    "               |          |                 |                 |          |\n" +
    "               |          |                 |                 |          |\n" +
    s"               |          ${uiBoard(1)(6)}-----------------${uiBoard(1)(5)}-----------------${uiBoard(1)(4)}          |\n" +
    "               |                            |                            |\n" +
    "               |                            |                            |\n" +
    s"               ${uiBoard(0)(6)}----------------------------${uiBoard(0)(5)}----------------------------${uiBoard(0)(4)}\n"
    updateString
  }
  def helpBoard(): String ={
    val helpString = "To access the Nodes see the following coordinates:\n" +
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
    helpString
  }

  def goodbyeScreen(): String ={
    val goodbyeString = "**********************************************************************************************\n" +
    "*                                  THANK YOU FOR PLAYING                                     *\n"   +
    "*  __________   __     __   ________      _____      ______    __    __           __         *\n"   +
    "* |___    ___| |  |   |  | |   _____|    |   _  \\   /  _   |  |  |  |  |         |  |        *\n"  +
    "*     |  |     |  |___|  | |  |_____     |  | \\  \\_/  / |  |  |  |  |  |         |  |        *\n" +
    "*     |  |     |   ___   | |  ______|    |  |  \\_____/  |  |  |  |  |  |         |  |        *\n"  +
    "*     |  |     |  |   |  | |  |_____     |  |           |  |  |  |  |  |______   |  |______  *\n"   +
    "*     |__|     |__|   |__| |________|    |__|           |__|  |__|  |_________|  |_________| *\n"   +
    "*                                        IN SCALA                                            *\n"   +
    "**********************************************************************************************\n"
    goodbyeString
  }
  override def update: Unit = {
    println(updateBoard(controller.board))
    if (currentPlayer.color == 0) { currentPlayer = controller.players(0) }
    else { currentPlayer = changePlayer(controller.players) }

    controller.checkBoardForMill(1)
    if(controller.amountOfPlayerStones(1) == 9 && controller.amountOfPlayerStones(2) == 9) {
      println(gamePhaseTwoBegin())
    }
    else { println(playerInitTurns) }
  }
}