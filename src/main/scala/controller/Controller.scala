package controller

import model.{Board, Player}

class Controller {

  def create_new_Board(): Vector[Vector[Int]] = {
    val board = new Board
    board.create_Board()
  }
  def create_new_Player(name: String, color: Int) : String = {
    val player = new Player(name, color)
    player.create_player()
    name + color.toString;
  }

  def check_color(color: Int): String ={
    if (color == 1){
      val color_str_wh = "white"
      return color_str_wh
    }
    if (color == 2){
      val color_str_bl = "black"
      return color_str_bl
    }
    else{
      val color_str_in = "Invalid color value!"
      return color_str_in
    }
  }

  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def remove_stone()

  //def select_stone()

  //def end_of_game()
}
