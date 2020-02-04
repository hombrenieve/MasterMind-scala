class ProposedCombination(combination: List[Color.Color]) {

  private val combination_ = combination

  def getResult(secret: SecretCombination): (Int, Int) =
    (0, 0)

  def calculateWhites(secret: SecretCombination): Int = {
    def calculateInnerWhites(secret: List[Color.Color], combination: List[Color.Color]): List[Success.Success] =
      (secret, combination) match {
        case (hs :: Nil, hc :: Nil) if hs == hc => List(Success.WHITE)
        case (_ :: Nil, _ :: Nil) => List(Success.EMPTY)
        case (hs :: ts, hc :: tc) if hs == hc => Success.WHITE :: calculateInnerWhites(ts, tc)
        case (_ :: ts, _ :: tc) => Success.EMPTY :: calculateInnerWhites(ts, tc)
      }
    calculateInnerWhites(secret.secret, combination_).filter(_ == Success.WHITE).foldLeft(0){(count, _) => count + 1}
  }

}
