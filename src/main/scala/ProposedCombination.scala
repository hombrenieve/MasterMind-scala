class ProposedCombination(combination: List[Color.Color]) {

  private val combination_ = combination

  private object Success extends Enumeration {
    type Success = Value
    val EMPTY, WHITE, BLACK = Value
  }

  def getResult(secret: SecretCombination): (Int, Int) = {
    val blacksResult = calculateBlacksResult(combination_, secret.secret)
    val result = calculateWhitesResult(combination_, secret.secret, blacksResult)
    (result.filter(_ == Success.BLACK).foldLeft(0) { (count, _) => count + 1 },
      result.filter(_ == Success.WHITE).foldLeft(0) { (count, _) => count + 1 })
  }

  private def calculateBlacksResult(combination: List[Color.Color], secret: List[Color.Color]): List[Success.Success] = {
    require(combination.size == secret.size)
    (secret, combination) match {
      case (hs :: Nil, hc :: Nil) if hs == hc => List(Success.BLACK)
      case (_ :: Nil, _ :: Nil) => List(Success.EMPTY)
      case (hs :: ts, hc :: tc) if hs == hc => Success.BLACK :: calculateBlacksResult(ts, tc)
      case (_ :: ts, _ :: tc) => Success.EMPTY :: calculateBlacksResult(ts, tc)
    }
  }

  private def markWhites(color: Color.Color, secret: List[Color.Color], result: List[Success.Success]): List[Success.Success] = {
    require(secret.size == result.size)
    (secret, result) match {
      case (hs :: Nil, hr :: Nil) if hs == color && hr == Success.EMPTY => List(Success.WHITE)
      case (_ :: Nil, hr :: Nil) => List(hr)
      case (hs :: ts, hr :: tr) if hs == color && hr == Success.EMPTY => Success.WHITE :: markWhites(color, ts, tr)
      case (_ :: ts, hr :: tr) => hr :: markWhites(color, ts, tr)
    }
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
