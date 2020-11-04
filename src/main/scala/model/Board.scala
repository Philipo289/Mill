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

  def setup_relevant_Stones(in: Stone, color: Int): String = {
    if(in.color == color) {"1"}
    else {"0"}
  }

  def vecToString(vec: Vector[String]): String = vec.mkString


  def check_board_for_mill(color: Int): Unit = {
    val millControlVector = Vector(
      Integer.parseInt("11100000", 2),
      Integer.parseInt("00111000", 2),
      Integer.parseInt("00001110", 2),
      Integer.parseInt("10000011", 2))

    val millCrossControlVector = Vector(
      Integer.parseInt("010000000100000001000000", 2),
      Integer.parseInt("000100000001000000010000", 2),
      Integer.parseInt("000001000000010000000100", 2),
      Integer.parseInt("000000010000000100000001", 2)
    )

    val relevantVector = stones.rows.map(i => i.map(j => setup_relevant_Stones(j, color)))

    val relevantIntVector = relevantVector.map(i => Integer.parseInt(vecToString(i), 2))
    val relevantIntFlatVector = Integer.parseInt(vecToString(relevantVector.flatMap(i => i.map(j => j.mkString))), 2)

    for{ controlVec <- millControlVector
         relevantVec <- relevantIntVector
    } {
      if ((controlVec & relevantVec) == controlVec)
      {
        println("mill")
      }
      else {
        println("no mill")
      }
    }
    println("Cross Check")
    for(controlCrossVec <- millCrossControlVector){
      if((controlCrossVec & relevantIntFlatVector) == controlCrossVec){
        println("mill")
      }
      else{
        println("no mill")
      }
    }
  }
}
