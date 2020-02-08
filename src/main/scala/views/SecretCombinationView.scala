package views

import models.SecretCombination

object SecretCombinationView {
  def write(secret: SecretCombination): Unit = {
    secret.secret.foreach(_ => GestorIO.write("* "))
    GestorIO.writeln("")
  }

  def writeClear(secret: SecretCombination) = {
    GestorIO.write("( ")
    secret.secret.foreach(item => {
      ColorView.write(item)
      GestorIO.write(" ")
    })
    GestorIO.write(")")
  }

}
