object mill {

    val color = ("black", "white")

    def main(args: Array[String]) = {

      //println("Hello, world")
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
      println(play_board)
    }


}
