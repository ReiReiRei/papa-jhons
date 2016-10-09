

/**
  * Created by ReiReiRei on 10/9/2016.3
  */
object Main {
  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._
    val customersNumber = readInt()
    val params = for (i <- 0 until customersNumber) yield readLine().split(" ").map(_.toInt)
    val customers = params.map ( x=> Customer(x(0),x(1))).toList
    val pizzeria = new Pizzeria
    val day = new PizzeriaWorkingDay(customers,pizzeria)
    val avTime = day.averageWaitingTime
    println(avTime.toInt)

  }
}

