package model

case class BoardMatrix[T](rows: Vector[Vector[T]]) {
  def this(size: Int, filling: T) = this(Vector.tabulate(3, (size / 3)) {(rectangle_num, position_num) => filling})

  def stone(rect_num: Int, pos_num: Int): T = rows(rect_num)(pos_num)
  def replaceStone(rect_num: Int, pos_num:Int, stone: T): BoardMatrix[T] = copy(rows.updated(rect_num, rows(rect_num).updated(pos_num, stone)))
}
