class ProposedCombination(val combination: List[Color.Color]) {

  private object Success extends Enumeration {
    type Success = Value
    val EMPTY, WHITE, BLACK = Value
  }

  def getResult(secret: SecretCombination): (Int, Int) = {
    val blacksResult = calculateBlacksResult(combination, secret.secret)
    val result = calculateWhitesResult(combination, secret.secret, blacksResult)
    (result.filter(_ == Success.BLACK).foldLeft(0) { (count, _) => count + 1 },
      result.filter(_ == Success.WHITE).foldLeft(0) { (count, _) => count + 1 })
  }

  private def calculateBlacksResult(combination: List[Color.Color], secret: List[Color.Color]): List[Success.Success] = {
    require(combination.size == secret.size)
    val combinationAndSecret = combination.zip(secret)
    combinationAndSecret.map(item =>
      item match {
        case (combItem, secrItem) if combItem == secrItem => Success.BLACK
        case _ => Success.EMPTY
    })
  }

  private def markWhites(color: Color.Color, secret: List[Color.Color], result: List[Success.Success]): List[Success.Success] = {
    require(secret.size == result.size)
    val secretAndPrevResult = secret.zip(result)
    secretAndPrevResult.map(item =>
      item match {
        case (secretItem, resultItem) if secretItem == color && resultItem == Success.EMPTY => Success.WHITE
        case (_, resultItem) => resultItem
    })
  }

  @scala.annotation.tailrec
  private def calculateWhitesResult(combination: List[Color.Color], secret: List[Color.Color], result: List[Success.Success]): List[Success.Success] = {
    require(secret.size == result.size)
    combination match {
      case hc :: Nil => markWhites(hc, secret, result)
      case hc :: tc => calculateWhitesResult(tc, secret, markWhites(hc, secret, result))
    }
  }


}
