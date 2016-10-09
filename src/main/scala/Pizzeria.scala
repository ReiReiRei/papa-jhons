import scala.collection.mutable

/**
  * Created by ReiReiRei on 10/9/2016.
  */
class Pizzeria {

  val served = List[Customer]()
  def averageWaitingTime = {
    val spendTime = served.foldLeft((0L,0L))( (acum,customer)=> (acum._1+(customer.out-customer.in),acum._2+1) )

  }


}

case class Customer(in:Long,pizzaTime:Long,out:Long = -1)




class Queue[T] {
  mutable.PriorityQueue[e
}
