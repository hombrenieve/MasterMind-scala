package models

class SecretCombination(forcedSecret: List[Color.Color] = Nil, dimension: Int = 4) {

  private def getRandomSecret() =
    (0 until dimension).map(_ => Color.random).toList

  val secret =
    forcedSecret match {
      case Nil => getRandomSecret()
      case _ => forcedSecret
    }
}
