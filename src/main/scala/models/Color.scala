package models

object Color extends Enumeration {
  type Color = Value
  val RED = Value('r')
  val BLUE = Value('b')
  val GREEN = Value('g')
  val PINK = Value('p')
  val YELLOW = Value('y')
  val ORANGE = Value('o')

  def random() = {
    val colors = Color.values
    val n = util.Random.nextInt(colors.size)
    colors.iterator.drop(n).next
  }
}
