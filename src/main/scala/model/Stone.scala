package model

case class Stone(val color: Int) {
  def isSet: Boolean = color != 0
  def value: Int = color
}
