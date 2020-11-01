package controller

import model.{Board, Player}
import util.Observable

class Controller(var board: Board) extends Observable{

  def create_empty_Board(): Unit = {
    board = new Board(24)
    notifyObservers
  }

  def set(rect_num: Int, pos_num: Int, value: Int): Unit = {
    board = board.update_board(rect_num, pos_num, value)
    notifyObservers
  }

  def create_new_Player() : Unit = {
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
