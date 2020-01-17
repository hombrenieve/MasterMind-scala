class SecretCombination(forcedSecret: List[Color.Color] = Nil) {

  private def getRandomSecret() =
    List(Color.RED, Color.RED, Color.RED, Color.RED)

  def secret =
    forcedSecret match {
      case Nil => getRandomSecret()
      case _ => forcedSecret
    }
}
