package ru.otus.sc

object se2 {

  sealed trait Option[+T]
  case object None                    extends Option[Nothing]
  final case class Some[+T](value: T) extends Option[T]

  def printIfAny[T](ot: Option[T]): Unit =
    ot match {
      case None        =>
      case Some(value) => println(value)
    }

  // TODO
  // with call-by-value
  def extGetOrDefault[T](ot: Option[T], default: T): T =
    ot match {
      case None        => default
      case Some(value) => value
    }

  // with call-by-name
  def getOrDefault[T](ot: Option[T], default: => T): T =
    ot match {
      case None        => default
      case Some(value) => value
    }

  def main(args: Array[String]): Unit = {
    val op  = Some(32)
    val not = None

    println("try to print Some with ext")
    println(extGetOrDefault(op, { println("called"); 2 }))

    println("try to print None with ext")
    println(extGetOrDefault(not, { println("called"); 2 }))

    println("try to print Some with get")
    println(getOrDefault(op, { println("called"); 2 }))

    println("try to print None with get")
    println(getOrDefault(not, { println("called"); 2 }))
  }
}
