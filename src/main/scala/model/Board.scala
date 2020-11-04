package model

case class Board(stones: BoardMatrix[Stone]) {
  def this() = this(new BoardMatrix[Stone](Stone(0)))

  def stone(rect_num: Int, pos_num: Int) = stones.stone(rect_num, pos_num)

  def update_board(rectangle_num: Int, position_num:Int, color:Int) : Board ={
    copy(stones.replaceStone(rectangle_num, position_num, Stone(color)))
  }
  def check_stone_Set(rectangle_num: Int, position_num: Int): Boolean ={
    stones.stone(rectangle_num, position_num).isSet
  }

  def color_matcher(in:Stone, color: Int):Int = {
    if(in.color == color){ 1 }
    else{ 0 }
  }
  // Total of 16 Mills
  /*def check_mill(color: Int): Boolean = {

    val controlVector =Vector(11100000, 111000, 1110, 10000011)
      val millColorBoard = stones.rows.map(i => i.map(j => color_matcher(j, color)))
      var test = false
      millColorBoard.foreach(i => {
        val colorStr = i.mkString.toInt
        controlVector.foreach(i => {
          if(colorStr == i){
            test = true
          }
        })
      })
    test
  }*/

  def amount_of_played_stones(color: Int): Int = {
    stones.amountOfPlayedStones(color)
  }
}
