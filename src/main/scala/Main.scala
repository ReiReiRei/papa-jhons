

/**
  * Created by ReiReiRei on 10/9/2016.
  */
class Main {
  def main(args: Array[String]): Unit = {
    import scala.io.StdIn._
    val customersNumber = readInt()
    val params = for (i <- 0 until customersNumber) yield readLine().split(" ").map(_.toInt).take(2)
  }
}

object