package ru.otus.bn

object bn1 {
  sealed trait Option[+T]
  case object None                    extends Option[Nothing]
  final case class Some[+T](value: T) extends Option[T]

  def extGetOrDefault[T](ot: Option[T])(default: T): T =
    ot match {
      case None        => default
      case Some(value) => value
    }

  def getOrElse[T](o: Option[T])(default: => T): T =
    o match {
      case None        => default
      case Some(value) => value
    }

  def main(args: Array[String]): Unit = {
    val a = extGetOrDefault(Some(32))(2)
    println(s"a is [$a]")

    val b =
      try {
        extGetOrDefault(Some(1)) {
          println("Next be exception")
          throw new Exception("That's wrong")
          2
        }
      } catch {
        case _: Exception => -1
      }
    println(s"b is [$b]")
  }

}
