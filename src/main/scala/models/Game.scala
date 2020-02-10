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

  def isLost = this.turn-1 == Game.MAX_TURN

  def turn = proposedCombinations.size+1

  def propose(proposal: List[Color.Color]): Game = {
    require(proposal.size == Game.DIMENSION)
    new Game(secret, new ProposedCombination(proposal, secret.secret) :: proposedCombinations)
  }

}
