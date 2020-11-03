package controller

import controller.GameStatus._
import model.{Board, Player, Stone}
import util.Observable

class Controller(var board: Board, var players: Vector[Player]) extends Observable{

  var gameStatus: GameStatus = IDLE

  def create_empty_Board(): Unit = {
    board = new Board
    notifyObservers
  }

  def setStone(rect_num: Int, pos_num: Int, value: Int): Unit = {
      board = board.update_board(rect_num, pos_num, value)
      notifyObservers
  }

  def checkInputCoordinates(rect_num: Int, pos_num: Int): Boolean = {
    if(rect_num < 1 || rect_num > 3){ false }
    else if(pos_num < 1 || pos_num > 8) { false }
    else{ true }
  }

  def amountOfPlayerStones(color: Int): Int = {
    board.amount_of_played_stones(color)
  }

  def checkStoneSet(rect_num: Int, pos_num: Int): Boolean = {
    board.check_stone_Set(rect_num, pos_num)
  }

  def create_new_Players(player1_name: String, player2_name: String) : Unit = {
    players = Vector(Player(player1_name, 1), Player(player2_name, 2))
    
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

  def remove_stone(rect_num: Int, pos_num: Int, color: Int): Unit = {
    board = board.update_board(rect_num, pos_num, color)
    notifyObservers
  }

  //def select_stone()

  //def end_of_game()
}
