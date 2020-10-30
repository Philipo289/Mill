package view

import controller.Controller

class Tui(controller: Controller) {

  def processInputLine(input: String): Unit = {
    input match {
      case "q" =>
      case "h" => helpBoard()
      case "n" =>
        updateBoard(controller.create_new_Board())
      case _ =>

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

  def color_matcher(in:Int):String = {
    in match {
      case 0 => "O"
      case 1 => "W"
      case 2 => "B"
      case _ => ""
    }
  }

  def updateBoard(board: Vector[Vector[Int]]): Unit={

    val uiBoard = board.map(i => i.map(color_matcher))

    println(s"               ${uiBoard(0)(0)}----------------------------${uiBoard(0)(1)}----------------------------${uiBoard(0)(2)}" )
    println("               |                            |                            |")
    println("               |                            |                            |")
    println(s"               |          ${uiBoard(1)(0)}-----------------${uiBoard(1)(1)}-----------------${uiBoard(1)(2)}          |")
    println("               |          |                 |                 |          |")
    println("               |          |                 |                 |          |")
    println(s"               |          |         ${uiBoard(2)(0)}-------${uiBoard(2)(1)}-------${uiBoard(2)(2)}         |          |")
    println("               |          |         |               |         |          |")
    println("               |          |         |               |         |          |")
    println(s"               ${uiBoard(1)(7)}----------${uiBoard(1)(7)}---------${uiBoard(2)(7)}               ${uiBoard(2)(3)}---------${uiBoard(1)(3)}----------${uiBoard(0)(3)}")
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
    println("               | (00)                       | (01)                  (02) |")
    println("               |                            |                            |")
    println("               |          O-----------------O-----------------O          |")
    println("               |          | (10)            | (11)       (12) |          |")
    println("               |          |            (21) |                 |          |")
    println("               |          |         O-------O-------O         |          |")
    println("               |          |         | (20)     (22) |         |          |")
    println("               |          |         |               |         |          |")
    println("               O----------O---------O (27)     (23) O---------O----------O")
    println("               | (07)     | (17)    |               |    (13) |     (03) |")
    println("               |          |         | (26)     (24) |         |          |")
    println("               |          |         O-------O-------O         |          |")
    println("               |          |            (25) |                 |          |")
    println("               |          | (16)            | (15)       (14) |          |")
    println("               |          O-----------------O-----------------O          |")
    println("               |                            |                            |")
    println("               | (06)                       | (05)                  (04) |")
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
