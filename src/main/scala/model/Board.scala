package model

class Board {

  def create_Board () = {
    val play_board: Vector[Vector[Int]] = Vector(Vector(0,0,0,0,0,0,0,0), Vector(0,0,0,0,0,0,0,0), Vector(0,0,0,0,0,0,0,0))
    play_board
  }

  def update_board(rectangle_num: Int, position_num:Int, color:Int, play_board: Vector[Vector[Int]])={
    val board = play_board.updated(rectangle_num, play_board(rectangle_num).updated(position_num, color))
    board
  }
}
