class Game(secret: SecretCombination, combinations: List[ProposedCombination], dimension: Int = 4, maxTurn: Int = 10) {

  private val result = combinations.head.getResult(secret)

  val blacks = this.result.blacks
  val whites = this.result.whites

  def isWinner = this.result.isWinner
  def isLost = this.turn == maxTurn

  def turn = combinations.size

  //def propose(proposal: ProposedCombination): Game =

}
