import org.scalatest._

/**
  * Created by ReiReiRei on 10/9/2016.
  */

class AverageTime extends FlatSpec {

  "Explanation00" should "be true" in {
    val customers = List(Customer(0, 3), Customer(1, 9), Customer(2, 6))
    val pizzeria = new Pizzeria
    val day = new PizzeriaWorkingDay(customers, pizzeria)
    assert(day.averageWaitingTime.toInt == 9)
  }

  "Explanation01" should "be true" in {
    val customers = List(Customer(0, 3), Customer(1, 9), Customer(2, 5))
    val pizzeria = new Pizzeria
    val day = new PizzeriaWorkingDay(customers, pizzeria)
    assert(day.averageWaitingTime.toInt == 8)
  }


}