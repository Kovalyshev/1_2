package ru.otus.sc

object se1 {
  // Option
  sealed trait Option[+T]
  case object None                   extends Option[Nothing]
  final case class Some[T](value: T) extends Option[T]

  // printIfAny
  def printIfAny[T](o: Option[T]): Unit =
    o match {
      case None        =>
      case Some(value) => println(value)
    }

  def main(args: Array[String]): Unit = {
    println("Try to print Some")
    val op = Some(324)
    printIfAny(op)

    println("Try to print None")
    val not = None
    printIfAny(not)
  }
}
