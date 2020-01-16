class Result(val blacks: Int, val whites: Int, dimension: Int = 4) {

  def isWinner =
    whites == dimension && blacks == 0

}
