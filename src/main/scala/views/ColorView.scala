package views

import models.Color.Color

object ColorView {
  def write(item: Color): Unit = {
    GestorIO.write(s"$item")
  }

}
