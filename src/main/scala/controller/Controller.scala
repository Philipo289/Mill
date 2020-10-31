package controller

import model.{Board, Player}

class Controller(var board: Board) {

  def create_empty_Board(): Unit = {
    board = new Board(24)}

  def set(rect_num: Int, pos_num: Int, value: Int): Unit = {
    board = board.update_board(rect_num, pos_num, value)
    println(board)
  }

  def create_new_Player() : Unit = {
    val player1 = new Player("Sebastian", 1, 1)
    val player2 = new Player("Soraya", 2, 2)
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
