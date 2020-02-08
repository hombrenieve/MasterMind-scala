package views

import models.{Color, ProposedCombination, SecretCombination}

object ProposedCombinationView {
  def read(secret: SecretCombination): ProposedCombination =
    new ProposedCombination(List(Color.RED, Color.RED, Color.RED, Color.RED), secret.secret)

  def write(combination: ProposedCombination): Unit = {
    GestorIO.write("(")
    combination.combination.foreach(item => ColorView.write(item))
    GestorIO.write(")")
    GestorIO.write(s" Result: ${combination.result}")
  }

}
