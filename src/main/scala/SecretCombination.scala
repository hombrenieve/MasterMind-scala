class SecretCombination(forcedSecret: List[Color.Color] = Nil, dimension: Int = 4) {

  private def getRandomSecret() =
    List(Color.RED, Color.RED, Color.RED, Color.RED)

  val secret =
    forcedSecret match {
      case Nil => getRandomSecret()
      case _ => forcedSecret
    }
}
