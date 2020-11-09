package model

case class Stone(val color: Int, var mill:Boolean) {
  def isSet: Boolean = color != 0

}
