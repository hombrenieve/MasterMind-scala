object Game {
  val DIMENSION = 4
  val MAX_TURN = 10
}


class Game(secret: SecretCombination, combinations: List[ProposedCombination]) {

  private val result = combinations.head.getResult(secret)
  val proposedCombinations = combinations

  def isWinner = result match {
    case (blacks, _) => blacks == Game.DIMENSION
    case _ => false
  }

  def isLost = this.turn == Game.MAX_TURN

  def turn = combinations.size

  def propose(proposal: ProposedCombination): Game = {
    require(proposal.combination.size == Game.DIMENSION)
    new Game(secret, proposal :: combinations)
  }

}
