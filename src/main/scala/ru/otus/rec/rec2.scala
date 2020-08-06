package ru.otus.rec

object rec2 {
  // List
  sealed trait List[+T] {
    def ::[H >: T](h: H): List[H] = Cons(h, this)
  }
  case object Nil                                 extends List[Nothing]
  final case class ::[+T](head: T, tail: List[T]) extends List[T]
  val Cons = ::

  def main(args: Array[String]): Unit = {
    val li = 1 :: 2 :: 3 :: 4 :: Nil
    println(s"list Ints [$li]")

    val ls = "1" :: "2" :: "3" :: "4" :: Nil
    println(s"list Strings [$ls]")
  }
}
