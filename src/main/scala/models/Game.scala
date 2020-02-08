package models

object Game {
  val DIMENSION = 4
  val MAX_TURN = 10
}


class Game(val secret: SecretCombination, val proposedCombinations: List[ProposedCombination] = Nil) {

  def isWinner: Boolean =
    proposedCombinations match {
      case Nil => false
      case h :: _ => h.result match {
        case (blacks, _) => blacks == Game.DIMENSION
        case _ => false
      }
    }

  def isLost = this.turn == Game.MAX_TURN

  def turn = proposedCombinations.size

  def propose(proposal: ProposedCombination): Game = {
    require(proposal.combination.size == Game.DIMENSION)
    new Game(secret, proposal :: proposedCombinations)
  }

}
