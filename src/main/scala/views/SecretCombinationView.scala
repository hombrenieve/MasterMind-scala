package views

import models.SecretCombination

object SecretCombinationView {
  def write(secret: SecretCombination): Unit = {
    secret.secret.foreach(_ => GestorIO.write("* "))
    GestorIO.writeln("")
  }

  def writeClear(secret: SecretCombination): Unit = {
    GestorIO.write(secret.secret)
  }

}
