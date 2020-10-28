import com.sun.org.apache.xml.internal.utils.StringToIntTable
import scala.math.Numeric.BigDecimalAsIfIntegral.mkNumericOps


class Board {
  val square_names = (1 to 3)


  def create_Board () = {


    val index_list = (0 to 7)
    val play_board = square_names.map(n => (n, index_list.map(n => n)))
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
    else{
      val color_str = "black"
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
  //def check_possible_moves(postion: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def select_stone()
}

val square_names = (1 to 3)
val index_min = 0
val index_max = 7

def create_Board () = {


  val index_list = (0 to 7)
  val play_board = square_names.map(n => (n, index_list.map(n => n)))
  play_board
}
println(create_Board())
