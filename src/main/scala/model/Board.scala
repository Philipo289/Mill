package model

class Board {

  def create_Board () = {
    val play_board: Vector[Vector[Int]] = Vector(Vector(0,0,0,0,0,0,0,0), Vector(0,0,0,0,0,0,0,0), Vector(0,0,0,0,0,0,0,0))
    play_board
  }

  def update_board(rectangle_num: Int, position_num:Int, color:Int, play_board: Vector[Vector[Int]])={
    val rectangle = play_board(rectangle_num).patch(position_num, Seq(color), 1)
    if (rectangle_num ==0){
      val board = (rectangle, play_board(1), play_board(2))
      board
    }
    if (rectangle_num ==1){
      val board = (play_board(0), rectangle, play_board(2))
      board
    }
    if (rectangle_num==2){
      val board = (play_board(0), play_board(1), rectangle)
      board
    }
  }
}
