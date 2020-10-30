package controller

import model.{Board, Player}

class Controller {

  def create_new_Board(): Vector[Vector[Int]] = {
    val board = new Board
    board.create_Board()
  }
  def create_new_Player(name: String, color: Int, code: Int) : String = {
    val player = new Player
    player.create_player(name, color, code)
    name + color.toString + code.toString;
  }

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

  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def remove_stone()

  //def select_stone()

  //def end_of_game()
}
