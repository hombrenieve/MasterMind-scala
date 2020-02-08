import models.{Game, SecretCombination}
import views.{GameView, GestorIO, ProposedCombinationView}

object Main {

  def play(game: Game): Boolean = {
    GameView.write(game)
    if(!game.isWinner && !game.isLost)
      play(game.propose(ProposedCombinationView.read(game.secret)))
    else
      game.isWinner
  }

  def main(args: Array[String]): Unit = {
    GestorIO.writeln("Welcome to MasterMind in Scala")
    play(new Game(new SecretCombination))
  }
}
