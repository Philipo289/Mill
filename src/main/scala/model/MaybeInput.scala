package model

case class MaybeInput(input:Option[Any]){
  def validLength: MaybeInput = input match {
    case Some(in: String) => if(in.length == 2) copy(Some(in)) else copy(None)
    case None => copy(None)
  }
  def validInt: MaybeInput = input match  {
    case Some(in: String) => if(in forall Character.isDigit) copy(Some(in)) else copy(None)
    case None => copy(None)
  }
  def validCoordinates: MaybeInput = input match {
    case Some(in: String) => {
      in.toList.filter(c => c != ' ').map(c => c.toString.toInt) match {
        case rect_num :: pos_num :: Nil => {
          if((rect_num > 0 && rect_num < 4) && (pos_num > 0 && pos_num < 9)){
            val intList = List(rect_num, pos_num)
            copy(Some(intList))
          }
          else{
            copy(None)
          }
        }
      }
    }
    case None => copy(None)
  }
  def validateStone(board: Board): MaybeInput = input match {
      case Some(in: List[Int]) => {
          if ( !board.check_stone_Set(in(0) - 1, in(1) - 1)) copy(Some(in)) else copy(None)
      }
      case None => copy(None)
    }
  def findValidNeighbors(board : Board): MaybeInput = input match {
    case Some(in: List[Int]) => {
      val list_corner = List(0, 2, 4, 6)
      val list_middle = List(1, 3, 5, 7)
      val input = List(in(0)-1, in(1)-1)
      if(list_corner.contains(input(1))){
        val possible_moves_rectangle = legal_moves_in_rectangle(input)
        val legal_moves = possible_moves_rectangle.filter(move => !board.check_stone_Set(input.head, input(1)) == move)
        copy(Some(legal_moves))
      }
      else if(list_middle.contains(input(1))){
        val possible_moves_rectangle = legal_moves_in_rectangle(input)
        val possible_moves_bt_rectangle = legal_moves_between_rectangles(input)
        val legal_moves = possible_moves_rectangle.filter(move => !board.check_stone_Set(input.head, input(1)) == move) ++ possible_moves_bt_rectangle.filter(move => !board.check_stone_Set(input.head, input(1))== move)
        copy(Some(legal_moves))
      }
      else {
        copy(None)
      }

    }
    case None => copy(None)
  }

  def checkStone(board: Board, color: Int): MaybeInput = input match {
    case Some(in: List[Int]) => {
      if (board.stone(in(0) - 1, in(1) - 1).color == color) copy(Some(in)) else copy(None)
    }
    case None => copy(None)
  }

  def legal_moves_in_rectangle(in: List[Int])={

    val list_of_moves = List((in.head, in(1)-1), (in.head, in(1)+1))
    val legal_moves_rectangle = list_of_moves.map(move => if (move._2<0) (move._1, 7) else move)
    legal_moves_rectangle
  }
  def legal_moves_between_rectangles(in: List[Int])= {
    val list_of_moves = List((in.head+1, in(1)), (in.head-1, in(1)))
    val legal_moves_bt_rectangles = list_of_moves.filter(move => move._1<2 && move._1>0)
    legal_moves_bt_rectangles

  }
}