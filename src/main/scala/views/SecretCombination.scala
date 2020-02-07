package views

import models.SecretCombination

object SecretCombination {
  def write(secret: SecretCombination): Unit = {
    secret.secret.foreach(_ => GestorIO.write("* "))
    GestorIO.writeln("")
  }

}
