package views

import models.Game

object GameView {
  def write(game: Game): Unit = {
    SecretCombinationView.write(game.secret)
    (1 to Game.MAX_TURN-game.turn).foreach(_ => GestorIO.writeln("( - - - - ) Result: (0,0)"))
    game.proposedCombinations.foreach(combination => {
      ProposedCombinationView.write(combination)
      GestorIO.writeln("")
    })
    if(game.isWinner)
      GestorIO.writeln("Congratulations!, you won!!")
    else if(game.isLost) {
      GestorIO.writeln("I'm sorry, but you have lost the game!")
      GestorIO.write("The combination was: ")
      SecretCombinationView.writeClear(game.secret)
      GestorIO.writeln("")
    } else
      GestorIO.writeln(s"Turn ${game.turn}/${Game.MAX_TURN}")
  }
}
