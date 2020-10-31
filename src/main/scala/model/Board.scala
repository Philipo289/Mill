package model

case class Board(stones: BoardMatrix[Stone]) {
  def this(size: Int) = this(new BoardMatrix[Stone](size, Stone(0)))


  def update_board(rectangle_num: Int, position_num:Int, color:Int) : Board ={
    copy(stones.replaceStone(rectangle_num, position_num, Stone(color)))
  }

  /*def update_board(rectangle_num: Int, position_num:Int, color:Int, play_board: Vector[Vector[Int]])={
    val board = play_board.updated(rectangle_num, play_board(rectangle_num).updated(position_num, color))
    board
  }*/
}
