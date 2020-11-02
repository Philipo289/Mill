package controller

import model.{Board, Player, Stone}
import util.Observable

class Controller(var board: Board, var players: Vector[Player]) extends Observable{

  def create_empty_Board(): Unit = {
    board = new Board
    notifyObservers
  }

  def setStone(rect_num: Int, pos_num: Int, value: Int): Boolean = {
    if(board.stone(rect_num, pos_num) == Stone(0)) {
      board = board.update_board(rect_num, pos_num, value)
      notifyObservers
      true
    }
    else{ false }
  }

  def create_new_Players(player1_name: String, player2_name: String) : Unit = {
    players = Vector(Player(player1_name, 1), Player(player2_name, 2))
  }

  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def remove_stone()

  //def select_stone()

  //def end_of_game()
}
