package views

import models.{Color, ProposedCombination}

object ProposedCombinationView {

  def read(): List[Color.Color] = {
    GestorIO.write("Valid colors are ")
    Color.values.foreach(item => GestorIO.write(item+" "))
    GestorIO.writeln("")
    val entry = GestorIO.readLine("Insert combination: ")
    entry.map(character => Color.withName(character.toString)).toList
  }

  def write(combination: ProposedCombination): Unit = {
    GestorIO.write(combination.combination)
    GestorIO.write(s" Result: ${combination.result}")
  }

}
