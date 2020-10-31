package view

import controller.Controller
import model.{Board, Stone}

class Tui(controller: Controller) {

  def processInputLine(input: String): Unit = {
    input match {
      case "q" => controller.create_new_Player()
      case "h" => helpBoard()
      case "n" => {
        controller.create_empty_Board()
        updateBoard(controller.board)
      }
      case _ => input.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
        case rect_num :: pos_num :: Nil => {
          controller.set((rect_num - 1), (pos_num - 1), 1)
          updateBoard(controller.board)
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
}
