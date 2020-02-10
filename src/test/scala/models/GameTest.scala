package models

import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("When all correct then it is winner") {
    val forcedSecret = List(Color.ORANGE, Color.BLUE, Color.RED, Color.PINK)
    val game = new Game(new SecretCombination(forcedSecret), List(new ProposedCombination(forcedSecret, forcedSecret)))
    assert(game.isWinner)
    assert(!game.isLost)
  }

  test("After several attempts last is winner") {
    val forcedSecret = List(Color.ORANGE, Color.YELLOW, Color.BLUE, Color.PINK)
    val combinations = List(
      new ProposedCombination(forcedSecret, forcedSecret),
      new ProposedCombination(List(Color.ORANGE, Color.RED, Color.BLUE, Color.PINK), forcedSecret),
      new ProposedCombination(List(Color.YELLOW, Color.RED, Color.BLUE, Color.PINK), forcedSecret),
    )
    val game = new Game(new SecretCombination(forcedSecret), combinations)
    assert(game.isWinner)
    assert(!game.isLost)
  }

  test("After several attempts is lost") {
    val forcedSecret = List(Color.ORANGE, Color.YELLOW, Color.BLUE, Color.RED)
    val incorrect = List(Color.ORANGE, Color.RED, Color.BLUE, Color.PINK)
    val combinations = (1 to Game.MAX_TURN).map(_ => new ProposedCombination(incorrect, forcedSecret)).toList
    val game = new Game(new SecretCombination(forcedSecret), combinations)
    assert(game.isLost)
    assert(!game.isWinner)
  }

  test("Game is win after propose") {
    val forcedSecret = List(Color.ORANGE, Color.BLUE, Color.BLUE, Color.PINK)
    val combinations = List(
      new ProposedCombination(List(Color.ORANGE, Color.RED, Color.BLUE, Color.PINK), forcedSecret),
      new ProposedCombination(List(Color.YELLOW, Color.RED, Color.BLUE, Color.PINK), forcedSecret),
    )
    val game = new Game(new SecretCombination(forcedSecret), combinations)
    assert(!game.isWinner)
    assert(!game.isLost)
    val gameWon = game.propose(forcedSecret)
    assert(!gameWon.isLost)
    assert(gameWon.isWinner)
  }

}
