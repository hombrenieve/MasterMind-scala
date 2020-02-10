package views

import models.{Color, ProposedCombination}

object ProposedCombinationView {
  def read() =
    List(Color.RED, Color.RED, Color.RED, Color.RED)

  def write(combination: ProposedCombination): Unit = {
    GestorIO.write(combination.combination)
    GestorIO.write(s" Result: ${combination.result}")
  }

}
