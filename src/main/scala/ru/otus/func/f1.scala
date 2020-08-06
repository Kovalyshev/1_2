package ru.otus.func

import scala.annotation.tailrec

object f1 {
  sealed trait List[+T] {
    def ::[H >: T](h: H): List[H] = Cons(h, this)
  }
  case object Nil                                 extends List[Nothing]
  final case class ::[+T](head: T, tail: List[T]) extends List[T]
  val Cons = ::

  @tailrec
  def reverse[T](l: List[T], acc: List[T] = Nil): List[T] =
    l match {
      case Nil          => acc
      case head :: tail => reverse(tail, head :: acc)
    }

  // def incList [1, 2, 3] => [2, 3, 4]

  def incList(l: List[Int]): List[Int] = {
    @scala.annotation.tailrec
    def inner(from: List[Int], to: List[Int]): List[Int] = {
      from match {
        case Nil            => to
        case ::(head, tail) => inner(tail, (head + 1) :: to)
      }
    }
    reverse(inner(l, Nil))
  }

  // def shoutList [1, 2, 3] => ["1!", "2!", "3!"]

  def shoutList(l: List[Int]): List[String] = {
    @scala.annotation.tailrec
    def inner(from: List[Int], to: List[String]): List[String] = {
      from match {
        case Nil            => to
        case ::(head, tail) => inner(tail, s"$head!" :: to)
      }
    }
    reverse(inner(l, Nil))
  }

  @scala.annotation.tailrec
  def mapList[T, R](from: List[T], to: List[R] = Nil)(f: T => R): List[R] = {
    from match {
      case Nil            => to
      case ::(head, tail) => mapList(tail, f(head) :: to)(f)
    }
  }

  def main(args: Array[String]): Unit = {
    val l = 1 :: 2 :: 3 :: Nil

    println(s"before [$l]")
    println(s"incList [${incList(l)}]")
    println(s"shoutList [${shoutList(l)}]")

    val incL = reverse(mapList(l) { _ + 1 })
    println(s"incMapList [$incL]")

    val shoutL = reverse(mapList(l) { el => s"$el!" })
    println(s"shoutMapList [$shoutL]")
  }
}
