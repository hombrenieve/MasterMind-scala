package views

import models.SecretCombination

object SecretCombinationView {
  def write(secret: SecretCombination): Unit = {
    GestorIO.write(secret.secret.map(_ => '*'))
  }

  def writeClear(secret: SecretCombination): Unit = {
    GestorIO.write(secret.secret)
  }

}
