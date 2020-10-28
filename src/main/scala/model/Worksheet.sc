import com.sun.org.apache.xml.internal.utils.StringToIntTable
import scala.math.Numeric.BigDecimalAsIfIntegral.mkNumericOps


class Board {
  val square_names = (1 to 3)


  def create_Board () = {



    // val index_list: List[Int] = List(0 to 7)
    val play_board: Vector[Vector[Int]] = Vector(Vector(0,1,2,3,4,5,6,7), Vector(0,1,2,3,4,5,6,7), Vector(0,1,2,3,4,5,6,7))
    play_board
  }
  println(create_Board())
}

/*class Field (square_name: String, index: Int, owner: Int){


}*/

class Player {

  def check_color(color: Int): String ={
    if (color == 1){
      val color_str = "white"
      color_str
    }
    if(color == 2){
      val color_str = "black"
      color_str
    }
    else {
      val color_str = "Invalid color code"
      color_str
    }

  }
  def create_player(name: String, color_int: Int, player_code: Int): Unit ={
    val name_player = name
    val color_player = color_int
  }



}

class Stones (position: Vector[Int], color: Int) {

}

class Controller {
  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def select_stone()
}

val square_names = (0,1,2)
val index_min = 0
val index_max = 7

def create_Board () = {



 // val index_list: List[Int] = List(0 to 7)
  val play_board: Vector[Vector[Int]] = Vector(Vector(0,1,2,3,4,5,6,7), Vector(0,1,2,3,4,5,6,7), Vector(0,1,2,3,4,5,6,7))
  play_board
}


val test_move = "1".toInt
val test_x = "1"
val test_y= "2"
val x = test_x.toInt
val y = test_y.toInt
val new_board = new Board

val test_board = new_board.create_Board()
val board_1 = new_board.create_Board()





)


