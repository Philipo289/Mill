package controller

import controller.GameStatus._
import model.{Board, Player, Stone}
import util.Observable

class Controller(var board: Board, var players: Vector[Player]) extends Observable{
  var newMill = false
  var gameStatus: GameStatus = IDLE

  def create_empty_Board(): Unit = {
    board = new Board
    notifyObservers
  }

  def setStone(rect_num: Int, pos_num: Int, value: Int): Unit = {
      val oldBoard = board;
      board = board.update_board(rect_num, pos_num, value)
      newMill = board.check_board_for_mill(oldBoard, value)
      notifyObservers
      notifyPlayerObserver
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
    players = Vector(Player(player1_name, 1, 9), Player(player2_name, 2, 9))
  }

  //def check_possible_moves(position: Vector[Int], color: Int)

  //def show_possible_moves()


  def getCompetitorStone(color: Int): Int ={
    color match {
      case 1 => 2
      case 2 => 1
      case _ => 0
    }
  }

  def remove_stone(rect_num: Int, pos_num: Int, color: Int): Boolean = {
    val compStoneColor = getCompetitorStone(color)

    if(board.stone(rect_num, pos_num) == Stone(compStoneColor, false)) {
      board = board.update_board(rect_num, pos_num, 0)
      println(board)
      players(compStoneColor - 1).MAX_STONE -= 1
      newMill = false;
      notifyObservers
      true
    }
    else{
      false
    }
  }

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


  def select_stone(rectangle_num: Int, position : Int, color: Int): Boolean = {
    if(Stone(color, false) == board.stones.stone(rectangle_num, position)){
      true
    }
    else{
      false
    }
  }

  //def select_stone()

  //def end_of_game()
}
