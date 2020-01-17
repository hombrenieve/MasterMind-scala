import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("When all whites is winner") {
    val game = new Game(new SecretCombination, List(new ProposedCombination(List("RED", "RED", "RED", "RED"))))
    assert(game.isWinner)
  }
}
