package views

import models.Color

import scala.io.StdIn

object GestorIO {

  def write[A](string:A):Unit =
    print(string)

  def writeln[A](string:A):Unit =
    println(string)

  def write[A](list: List[A]):Unit = {
    print("( ")
    list.foreach(item => {
      print(item+" ")
    })
    print(")")
  }

  def readLine(title: String): String = {
    write(title)
    StdIn.readLine()
  }


}
