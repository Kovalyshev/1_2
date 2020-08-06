package ru.otus.rec

object rec3 {

  sealed trait List[+T] {
    def ::[H >: T](h: H): List[H] = Cons(h, this)
  }
  case object Nil                                 extends List[Nothing]
  final case class ::[+T](head: T, tail: List[T]) extends List[T]
  val Cons = ::

  // reverse
  def reverse[T](l: List[T]): List[T] = {
    @scala.annotation.tailrec
    def inner(from: List[T], to: List[T]): List[T] = {
      from match {
        case Nil          => to
        case head :: tail => inner(tail, head :: to)
      }
    }

    inner(l, Nil)
  }

  def main(args: Array[String]): Unit = {
    val l = 1 :: 2 :: 3 :: 4 :: Nil
    println(s"before [$l]")

    val revL = reverse(l)
    println(s"reversed [$revL]")
  }
}
