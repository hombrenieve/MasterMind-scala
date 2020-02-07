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
    (secret, result) match {
      case (hs :: Nil, Success.EMPTY :: Nil) if hs == color => List(Success.WHITE)
      case (_ :: Nil, hr :: Nil) => List(hr)
      case (hs :: _, Success.EMPTY :: tr) if hs == color => Success.WHITE :: tr
      case (_ :: ts, hr :: tr) => hr :: markWhites(color, ts, tr)
    }
  }

  private def calculateWhitesResult(combination: List[Color.Color], secret: List[Color.Color], result: List[Success.Success]): List[Success.Success] = {
    require(combination.size == result.size)
    val combinationsLeft = combination.zip(result).filter(item => item._2 == Success.EMPTY).map(item => item._1)
    combinationsLeft.foldLeft(result)((prevResult, color) => markWhites(color, secret, prevResult))
  }


}
