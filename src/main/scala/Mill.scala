import model.{Board, Player}

import controller.Controller
import view.Tui

import scala.io.StdIn.readLine

object Mill {

  //val color = ("black", "white")

  val controller = new Controller(new Board, Vector())
  val tui = new Tui(controller)

  def main(args: Array[String]) = {

    var input: String = ""
    tui.welcomeScreen()

    do{
      input = readLine()
      tui.processInputLine(input)
        if(input == "n"){
          playerInputIteration()
          //tui.currentPlayer = controller.players(0)
          tui.gameBegin()
          controller.create_empty_Board()
          do{
            input = readLine()
            tui.processGameInputLine(input)
          } while (input != "q") // || Spielende
        }
    } while(input != "q")

    tui.goodbyeScreen()

    /*println("Hello, world")
    println("Play 1 Name:")
      val player_1 = new Player
      val player_code_1 = 1
      // Read a line from the console window.
      val name_1 = scala.io.StdIn.readLine()
      // Write the result string and a newline.
      val color_1 = 1
      player_1.create_player(name_1, color_1, player_code_1)

      val player_2 = new Player
      val player_code_2 = 2
      println("Play 2 Name:")
      val name_2 = scala.io.StdIn.readLine()
      // Write the result string and a newline.
      val color_2 =2
      player_2.create_player(name_2, color_2, player_code_2)

      //val play_mode : Int = scala.io.StdIn.readLine().toInt
      val play_board = new Board
      play_board.create_Board()
      println(play_board)*/
  }
  def playerInputIteration(): Unit ={
    tui.playerOneName()
    val playerOneName = readLine()
    tui.playerTwoName()
    val playerTwoName = readLine()
    controller.create_new_Players(playerOneName, playerTwoName)
  }
}
