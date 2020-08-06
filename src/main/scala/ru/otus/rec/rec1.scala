package ru.otus.rec

object rec1 {
  // 10!

  def factorialA(i: Int): Long = {
    var acc: Long = 1
    var iter: Int = i

    while (iter >= 1) {
      acc = iter * acc
      iter -= 1
    }

    acc
  }

  def factorialRec(i: Int): Long = {
    if (i <= 1) 1
    else i * factorialRec(i - 1)
  }

  def factorialTail(i: Int, acc: Long = 1): Long = {
    if (i <= 1) acc
    else factorialTail(i - 1, i * acc)
  }

  def main(args: Array[String]): Unit = {
    val a = factorialA(4)
    println(s"a is [$a]")

    val b = factorialRec(4)
    println(s"b is [$b]")

    val c = factorialTail(4)
    println(s"c is [$c]")
  }
}
