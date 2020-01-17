object GameConstants {
  val DIMENSION = 4
  val MAX_TURN = 10
  val COLORS = List("RED", "BLUE", "GREEN", "PINK", "YELLOW")
}


class Game(secret: SecretCombination, combinations: List[ProposedCombination]) {

  private val result = combinations.head.getResult(secret)
  val proposedCombinations = combinations

  def isWinner = result match {
    case (_, whites) => whites == GameConstants.DIMENSION
    case _ => false
  }

  def isLost = this.turn == GameConstants.MAX_TURN

  def turn = combinations.size

  def propose(proposal: ProposedCombination): Game =
    new Game(secret, proposal :: combinations)

}
