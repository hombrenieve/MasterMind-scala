package views

import models.Game

object GameView {
  def write(game: Game): Unit = {
    SecretCombination.write(game.secret)
    game.proposedCombinations.foreach(combination => {
      ProposedCombinationView.write(combination)
      GestorIO.writeln("")
    })
    if(game.isWinner)
      GestorIO.writeln("Congratulations!, you won!!")
    else if(game.isLost)
      GestorIO.writeln("I'm sorry, but you have lost the game!")
    else
      GestorIO.writeln(s"Turn ${game.turn}/${Game.MAX_TURN}")
  }
}
