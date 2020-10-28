package model

class Board {
  val square_names = (1 to 3)

  def create_Board () = {
    val index_list = (0 to 7)
    val play_board = square_names.map(n => (n, index_list.map(n => n)))
    play_board
  }
}
