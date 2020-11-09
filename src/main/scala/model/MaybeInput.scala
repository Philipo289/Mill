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
          if ( !board.check_stone_Set(in(0) - 1, in(1) - 1)) {
            copy(Some(in))
          }
          else {
            copy(None)
          }
      }
      case None => copy(None)
    }
}