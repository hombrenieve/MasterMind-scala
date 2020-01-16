class ProposedCombination(combination: List[Char], dimension: Int = 4) {

  private val combination_ = combination

  def getResult(secret: SecretCombination): Result =
    new Result(0, 0, dimension)

}
