import scala.annotation.tailrec
import scala.collection.mutable

/**
  * Created by ReiReiRei on 10/9/2016.
  */

case class Customer(in: Long, pizzaTime: Long, out: Long = -1) extends Ordering[Customer] {
  override def compare(x: Customer, y: Customer): Int = {
    y.pizzaTime compare x.pizzaTime // the less time pizza need for the client the less other client wait
  }
}

class Pizzeria {

  val served = mutable.ListBuffer[Customer]()
  val queue = new mutable.PriorityQueue[Customer]()

  def averageWaitingTime = {
    val spentTime = served.foldLeft((0L, 0L))((acum, customer) => (acum._1 + (customer.out - customer.in), acum._2 + 1))
    val averageWaiting = if (spentTime._2 == 0) 0 else (spentTime._1 / spentTime._1)
    averageWaiting
  }

  def serve(currentTime: Long): Long = {
    val serveTime = try {
      val servingCustomer = queue.dequeue()
      val servedCustomer = servingCustomer.copy(out = currentTime + servingCustomer.pizzaTime)
      served += servedCustomer
      servingCustomer.pizzaTime
    } catch {
      case e: NoSuchElementException => 0
    }
    serveTime
  }

  def addCustomer(customer: Customer) = {
    queue.enqueue(customer)
  }

}

class PizzeriaWorkingDay(schedule: List[Customer], val pizzeria: Pizzeria) {

  private val customersOrdered = schedule.sortWith(_.in < _.in)
  private var willCome = customersOrdered
  private var time = 0

  private def addCustomersToQueue() = {
    while (time >= willCome.head.in && !willCome.isEmpty) {
      pizzeria.addCustomer(willCome.head)
      willCome = willCome.tail
    }
  }
 @tailrec private def tictac(): Boolean = {
    val serveTime = pizzeria.serve(time)
    if( serveTime == 0) time +=1 else  time +=serveTime
    if(!willCome.isEmpty) tictac() else false
  }

  tictac()


}

