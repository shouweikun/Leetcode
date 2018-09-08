package quiz51_100

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
/**
  * Created by john_liu on 2018/9/6.
  */
object temp {

  def main(args: Array[String]): Unit = {
  val a=   for{
       _ <- Future(Thread.sleep(10000))
       _ <- Future(println("dfdfd"))
    } yield ()

    Await.result(a,15 seconds)
  }

}
