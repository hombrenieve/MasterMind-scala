import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("When all whites is winner") {
    val game = new Game(new SecretCombination, List(new ProposedCombination(List(Color.PINK, Color.PINK, Color.PINK, Color.PINK))))
    assert(game.isWinner)
  }
}
