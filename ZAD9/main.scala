import scala.runtime.Nothing$
import scala.util.Try

object Cwiczenie9 {

  def main(args: Array[String]): Unit = {

    val cont = new Container(10)
    println("Type of " +cont.getContent + " = " + cont.applyFunction(cont.getContent))

    val cont1 = new Container("Hello World!")
    println("Type of " +cont1.getContent + " = " + cont1.applyFunction(cont1.getContent))

    val cont2 = new Container(3.14159265359)
    println("Type of " +cont2.getContent + " = " + cont2.applyFunction(cont2.getContent))

    val no = new No
    val yes = new Yes("indeed")
    println("no is an instance of Maybe: " + no.isInstanceOf[Maybe[_]])
    println("yes is an instance of Maybe: " + yes.isInstanceOf[Maybe[String]])

    println(no.ApplyFunction())
    println(yes.ApplyFunction("indeed"))

    val nope: getOrElse[No[_]] = new getOrElse[No[_]](new No)
    println(nope.getOrElse)
    val yep: getOrElse[Yes[String]] = new getOrElse[Yes[String]](new Yes("Yup, that's a yes"))
    println(yep.getOrElse)
  }
}

class Container[A](private val value : A) {
  private val _value: A = value

  def getContent: A = _value

  def applyFunction(value:A) : Unit = println(plusOne(value))

  private def plusOne(a: A): String = (a.toString + " plus one!")
}

trait Maybe[A] {
  def ApplyFunction[A](a : A*): String
}

class No[A] extends Maybe[Nothing] {
  override def ApplyFunction[A](a : A*): String = {
    if (a.isEmpty) "No"
    else "Yes, " + a + " " + a.getClass
  }
}

class Yes[A](val value: A) extends Maybe[A] {
  val _value: A = value

  override def ApplyFunction[A](a : A*): String = {
    if (a.isEmpty) "No"
    else "Yes, " + a + " " + a.getClass
  }
}

class getOrElse[A](value: A) {
  val _value: A = value
  def getOrElse[B]: B =
    _value match {
      case _: Yes[_] => _value.asInstanceOf[Yes[A]]._value.asInstanceOf[B]
      case _: No[A] => "Nic tu nie ma".asInstanceOf[B]
    }
}