package ru.otus.imm

object imm1 {
  case class Person(firstName: String, lastName: String, age: Int)

  def main(args: Array[String]): Unit = {
    val person = Person("John", "Doe", 33)
    println(s"Person sample [$person]")

    // person.age += 1
    val oldPerson = person.copy(age = person.age + 1)
    println(s"Old person [$oldPerson]")

    val familyDoePersons = (name: String, age: Int) => Person(name, "Doe", age)
    println(familyDoePersons("Den", 35))
  }
}
