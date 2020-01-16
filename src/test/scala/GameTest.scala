import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("When all whites is winner") {
    val game = new Game(new SecretCombination, List[new ProposedCombination(List['r', 'r', 'r', 'r'])])
    assert(game.isWinner)
  }
}
