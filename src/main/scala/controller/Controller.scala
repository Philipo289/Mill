package controller

import model.{Board, Player, Stone}
import util.Observable

class Controller(var board: Board, var players: Vector[Player]) extends Observable{

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
  }


  def check_stone_color(rectangle_num:Int, position:Int): Stone ={
    val stone_color = board.stones.stone(rectangle_num, position)
    stone_color
  }
    //def check_possible_moves(position: Vector[Int], color: Int)

    //def show_possible_moves()

  def move_stone(rectangle_num: Int, position: Int, stone: Int, rectangle_num_new:Int, position_new:Int): Boolean ={
    if(select_stone(rectangle_num, position, stone)==true){
      board = board.update_board(rectangle_num, position, 0)
      board = board.update_board(rectangle_num_new, position_new, stone)
      true
    }
    else{
      false
    }

  }

    //def remove_stone()

  def select_stone(rectangle_num: Int, position : Int, stone: Int): Boolean = {
    if(Stone(stone) == check_stone_color(rectangle_num, position)){
      true
    }
    else{
      false
    }
  }

    //def end_of_game()


  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()

  //def move_stone()

  //def remove_stone()

  //def select_stone()

  //def end_of_game()
}
