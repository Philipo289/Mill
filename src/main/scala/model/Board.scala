package model

case class Board(stones: BoardMatrix[Stone]) {
  def this() = this(new BoardMatrix[Stone](Stone(0)))

  def stone(rect_num: Int, pos_num: Int) = stones.stone(rect_num, pos_num)

  def update_board(rectangle_num: Int, position_num:Int, color:Int) : Board ={
    copy(stones.replaceStone(rectangle_num, position_num, Stone(color)))
  }
  def check_stone_Set(rectangle_num: Int, position_num:Int): Boolean ={
    stones.stone(rectangle_num, position_num).isSet
  }

  def amount_of_played_stones(color: Int): Int = {
    stones.amountOfPlayedStones(color)
  }
}
