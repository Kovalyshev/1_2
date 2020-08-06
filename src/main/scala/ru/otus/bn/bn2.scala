package ru.otus.bn

object bn2 {
  // while

  def mWhile(c: => Boolean)(b: => Unit): Unit = {
    if (c) {
      b
      mWhile(c)(b)
    } else
      ()
  }

  def main(args: Array[String]): Unit = {
    var i = 10
    mWhile(i >= 1) {
      println(s"i[$i]")
      i -= 1
    }
  }
}
