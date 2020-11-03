import controller.Controller
import model.Board
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
          tui.gamePhaseOneBegin()
          controller.create_empty_Board()
          do{
            input = readLine()
            tui.processGameInputLine(input)
          } while (input != "q") // || Spielende
        }
    } while(input != "q")

    tui.goodbyeScreen()
  }
  def playerInputIteration(): Unit ={
    tui.playerOneName()
    val playerOneName = readLine()
    tui.playerTwoName()
    val playerTwoName = readLine()
    controller.create_new_Players(playerOneName, playerTwoName)
  }
}
