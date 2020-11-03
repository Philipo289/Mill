package model


case class Player(val name: String, val color: Int)

case class Player(name: String, color:Int) {

  def create_player(): Player ={
    val name_player = name
    val color_player = color
    val player = new Player(name_player, color_player)
    player
  }
}

