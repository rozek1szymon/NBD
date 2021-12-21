import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

// Cwiczenie 1

val daysOfTheWeek = List(
  "poniedzialek", "wtorek", "sroda",
  "czawartek", "piatek", "sobota",
  "niedziela"
)

println(daysOfTheWeek)

// podpunkt a

def concatDaysWithFor(days: List[String]) : String = {

  var containerString = days(0)

  for (i <- 1 until days.length)
    containerString += (", " + days(i))

  containerString

}

println("1a Result: " + concatDaysWithFor(daysOfTheWeek))


// podpunkt b

def concatDaysThatStartsWithP(days: List[String]) : String = {

  var daysThatStartWithP = new ListBuffer[String]()

  for (i <- 0 until days.length)
    if (days(i).toLowerCase().startsWith("p"))
      daysThatStartWithP += days(i)

  concatDaysWithFor(daysThatStartWithP.toList)

}

println("1b Result: " + concatDaysThatStartsWithP(daysOfTheWeek))


// podpunkt c

def concatDaysWithWhile(days: List[String]) : String = {

  var containerString = days(0)
  var i = 1

  while (i < days.length) {
    containerString += (", " + days(i))
    i += 1
  }

  containerString

}

println("1c Result: " + concatDaysWithWhile(daysOfTheWeek))
println()

// Cwiczenie 2

// podpunkt a

def concatDaysReccurence(days: List[String]) : String = {

  def recursionConcatHelper(days: List[String], accumulator: String) : String = {
    days match{
      case Nil => accumulator
      case head :: tail => recursionConcatHelper(tail, accumulator + ", " + head)
    }
  }

  recursionConcatHelper(days.tail, days.head)

}

println("2a Result: " + concatDaysReccurence(daysOfTheWeek))


// podpunkt b

def concatDaysReccurenceBackwards(days: List[String]) : String = {

  def recursionConcatHelper(days: List[String], accumulator: String) : String = {
    days match{
      case Nil => accumulator
      case head :: tail => recursionConcatHelper(tail, head + ", " + accumulator)
    }
  }

  recursionConcatHelper(days.tail, days.head)

}


println("2b Result: " + concatDaysReccurenceBackwards(daysOfTheWeek))
println()

// Cwiczenie 3

def concatDaysTailReccurence(days: List[String]) : String = {
  @tailrec
  def recursionConcatHelper(days: List[String], accumulator: String) : String = {
    days match{
      case Nil => accumulator
      case head :: tail => recursionConcatHelper(tail, accumulator + ", " + head)
    }
  }

  recursionConcatHelper(days.tail, days.head)

}

println("3  Result: " + concatDaysReccurence(daysOfTheWeek))

println()
// Cwiczenie 4

// podpunkt a


def concatDaysWithFoldL(days: List[String]) : String = {
  return days.tail.foldLeft(daysOfTheWeek.head){
    (accumulator, currentDay) => (accumulator + ", " + currentDay)
  }

}

println("4a Result: " + concatDaysWithFoldL(daysOfTheWeek))

// podpunkt b

def concatDaysWithFoldR(days: List[String]) : String = {
  return days.init.foldRight(daysOfTheWeek.last){
    (accumulator, currentDay) => (accumulator + ", " + currentDay)
  }

}

println("4b Result: " + concatDaysWithFoldR(daysOfTheWeek))

// podpunkt c


def concatDaysThatStartsWithpWithFoldL(days: List[String]) : String = {
  return days.tail.foldLeft(daysOfTheWeek.head){ (accumulator, currentDay) =>
    currentDay match {
      case currentDay if currentDay.startsWith("p") => (accumulator + ", " + currentDay)
      case _ => accumulator
    }
  }
}

println("4c Result: " + concatDaysThatStartsWithpWithFoldL(daysOfTheWeek))


println()
// Cwiczenie 5

val productsPrices = Map("Skarpetki" -> 10, "Spodnie" -> 70, "Bluza" -> 150)
val lowerPrices = productsPrices.map({
  case (product, price) => (product, price * .9)
})

println(productsPrices)
println("5  Result: " + lowerPrices)

// Cwiczenie 6

def printThreeThings(tuple: Tuple3[Int, String, Boolean]) : Unit = {
  println(tuple)
}

println("6 Result: " )
printThreeThings((18, " years old", true))

// Cwiczenie 7

println("7 Result: " )
println(productsPrices.get("Skarpetki"))

val priceOfSockMaybe = productsPrices.get("Skarpetka")
priceOfSockMaybe match {
  case Some(price) => println(price)
  case None => println("No price for sock")
}


// Cwiczenie 8

def removeZiobrosFromList(numbers: List[Int]) : List[Int] = {
  def removeZiobrosHelper(numbers: List[Int], accumulator: List[Int]) : List[Int] = {
    numbers match{
      case Nil => accumulator
      case 0 :: tail => removeZiobrosHelper(tail, accumulator)
      case head :: tail => removeZiobrosHelper(tail, accumulator ::: List(head))
    }
  }

  removeZiobrosHelper(numbers, List())

}


println("8 Result: " + removeZiobrosFromList(List(1, 0, 2, 0 , 3, 0, 4)))

// Cwiczenie 9

def incrementList(numbers: List[Int]) : List[Int] = {
  return numbers.map((x) => (x + 1))
}


println("9 Result: " + incrementList(List(1, 0, 2, 0 , 3, 0, 4)))

// Cwiczenie 10

def absFromMinusFiveToTwelf(numbers: List[Double]) : List[Double] = {
  return numbers.filter(x =>(x >= -5)).filter(x =>(x <= 12)).map((x) => (x.abs))
}


println("10 Result: " + absFromMinusFiveToTwelf(List(1.2367, -200, 22, 0.62 , -3, 0, 4)))