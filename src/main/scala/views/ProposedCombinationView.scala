package views

import models.ProposedCombination

object ProposedCombinationView {
  def write(combination: ProposedCombination): Unit = {
    GestorIO.write("(")
    combination.combination.foreach(item => ColorView.write(item))
    GestorIO.write(")")
    GestorIO.write(s" Result: ${combination.result}")
  }

}
