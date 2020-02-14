package views

import models.{Game, SecretCombination}

object GameView {

  private def secretWriter(game: Game) =
    if(game.isWinner || game.isLost)
      SecretCombinationView.writeClear(game.secret)
    else
      SecretCombinationView.write(game.secret)


  def write(game: Game): Unit = {
    secretWriter(game)
    GestorIO.writeln("")
    (1 to Game.MAX_TURN+1-game.turn).foreach(_ => {
      GestorIO.write("( ")
      (1 to Game.DIMENSION).foreach(_ => GestorIO.write("- "))
      GestorIO.writeln(") Result: (0,0)")
    })
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
