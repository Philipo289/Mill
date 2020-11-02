package view

import controller.Controller
import model.{Board, Player, Stone}
import util.Observer

class Tui(controller: Controller) extends Observer{

  controller.add(this)
  var currentPlayer = new Player("", 0)

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "h" => helpBoard()
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
      case _ => {
        input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
          case rect_num :: pos_num :: Nil => {
            println(controller.amountOfPlayerStones(currentPlayer.color))
            val validCoordinates = controller.checkInputCoordinates(rect_num, pos_num)
            if(validCoordinates){
              val validStone = controller.checkStoneSet(rect_num - 1, pos_num - 1)
              if( !validStone) {
                controller.setStone((rect_num - 1), (pos_num - 1), currentPlayer.color)
              }
              else { stoneWarning() }
            }
            else{ coordinationWarning() }
          }
        }
      }
    }
  }
  def welcomeScreen(): Unit ={
    println("**********************************************************************************************"  )
    println("*                                       WELCOME TO                                           *"  )
    println("*  __________   __     __   ________      _____      ______    __    __           __         *"  )
    println("* |___    ___| |  |   |  | |   _____|    |   _  \\   /  _   |  |  |  |  |         |  |        *" )
    println("*     |  |     |  |___|  | |  |_____     |  | \\  \\_/  / |  |  |  |  |  |         |  |        *")
    println("*     |  |     |   ___   | |  ______|    |  |  \\_____/  |  |  |  |  |  |         |  |        *" )
    println("*     |  |     |  |   |  | |  |_____     |  |           |  |  |  |  |  |______   |  |______  *"  )
    println("*     |__|     |__|   |__| |________|    |__|           |__|  |__|  |_________|  |_________| *"  )
    println("*                                        IN SCALA                                            *"  )
    println("**********************************************************************************************"  )
    println("Press 'n' for new Game\nPress 'h' for help\nPress 'q' to quit"                                                           )
  }

  def playerOneName(): Unit ={
    print("Please enter name of player one: ")
  }
  def playerTwoName(): Unit ={
    print("Please enter name of player two: ")
  }

  def gameBegin(): Unit = {
    println("Let the game begin.")
    println("Game Phase One: Please place your stones on a free field.")
  }

  def stoneWarning(): Unit = {
    println("Stone location already used.")
    println("Please select another free coordinates.")
  }
  def coordinationWarning(): Unit = {
    println("Invalid coordinates entered.")
    println("Please select another free coordinates.")
  }

  def playerInitTurns(): Unit ={
    println(s"\n${currentPlayer.name} it is your turn Place one stone on a specific coordinate (${controller.amountOfPlayerStones(currentPlayer.color)} of 9): ")
  }

  def color_matcher(in:Stone):String = {
    in.color match {
      case 0 => "O"
      case 1 => "W"
      case 2 => "B"
      case _ => ""
    }
  }

  def updateBoard(board: Board): Unit={

    val uiBoard = board.stones.rows.map(i => i.map(color_matcher))

    println(s"               ${uiBoard(0)(0)}----------------------------${uiBoard(0)(1)}----------------------------${uiBoard(0)(2)}" )
    println("               |                            |                            |")
    println("               |                            |                            |")
    println(s"               |          ${uiBoard(1)(0)}-----------------${uiBoard(1)(1)}-----------------${uiBoard(1)(2)}          |")
    println("               |          |                 |                 |          |")
    println("               |          |                 |                 |          |")
    println(s"               |          |         ${uiBoard(2)(0)}-------${uiBoard(2)(1)}-------${uiBoard(2)(2)}         |          |")
    println("               |          |         |               |         |          |")
    println("               |          |         |               |         |          |")
    println(s"               ${uiBoard(0)(7)}----------${uiBoard(1)(7)}---------${uiBoard(2)(7)}               ${uiBoard(2)(3)}---------${uiBoard(1)(3)}----------${uiBoard(0)(3)}")
    println("               |          |         |               |         |          |")
    println("               |          |         |               |         |          |")
    println(s"               |          |         ${uiBoard(2)(6)}-------${uiBoard(2)(5)}-------${uiBoard(2)(4)}         |          |")
    println("               |          |                 |                 |          |")
    println("               |          |                 |                 |          |")
    println(s"               |          ${uiBoard(1)(6)}-----------------${uiBoard(1)(5)}-----------------${uiBoard(1)(4)}          |")
    println("               |                            |                            |")
    println("               |                            |                            |")
    println(s"               ${uiBoard(0)(6)}----------------------------${uiBoard(0)(5)}----------------------------${uiBoard(0)(4)}" )
  }
  def helpBoard(): Unit ={
    println("To access the Nodes see the following coordinates:\n")
    println("               O----------------------------O----------------------------O" )
    println("               | (11)                       | (12)                  (13) |")
    println("               |                            |                            |")
    println("               |          O-----------------O-----------------O          |")
    println("               |          | (21)            | (22)       (23) |          |")
    println("               |          |            (32) |                 |          |")
    println("               |          |         O-------O-------O         |          |")
    println("               |          |         | (31)     (33) |         |          |")
    println("               |          |         |               |         |          |")
    println("               O----------O---------O (38)     (34) O---------O----------O")
    println("               | (18)     | (28)    |               |    (24) |     (14) |")
    println("               |          |         | (37)     (35) |         |          |")
    println("               |          |         O-------O-------O         |          |")
    println("               |          |            (36) |                 |          |")
    println("               |          | (27)            | (26)       (25) |          |")
    println("               |          O-----------------O-----------------O          |")
    println("               |                            |                            |")
    println("               | (17)                       | (16)                  (15) |")
    println("               O----------------------------O----------------------------O")

  }

  def goodbyeScreen(): Unit ={
    println("**********************************************************************************************"  )
    println("*                                  THANK YOU FOR PLAYING                                     *"  )
    println("*  __________   __     __   ________      _____      ______    __    __           __         *"  )
    println("* |___    ___| |  |   |  | |   _____|    |   _  \\   /  _   |  |  |  |  |         |  |        *" )
    println("*     |  |     |  |___|  | |  |_____     |  | \\  \\_/  / |  |  |  |  |  |         |  |        *")
    println("*     |  |     |   ___   | |  ______|    |  |  \\_____/  |  |  |  |  |  |         |  |        *" )
    println("*     |  |     |  |   |  | |  |_____     |  |           |  |  |  |  |  |______   |  |______  *"  )
    println("*     |__|     |__|   |__| |________|    |__|           |__|  |__|  |_________|  |_________| *"  )
    println("*                                        IN SCALA                                            *"  )
    println("**********************************************************************************************"  )
  }
  override def update: Unit = {
    updateBoard(controller.board)
    if (currentPlayer.color == 0) { currentPlayer = controller.players(0) }
    else { currentPlayer = changePlayer(controller.players) }
    playerInitTurns()
  }
}