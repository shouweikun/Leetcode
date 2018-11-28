package quiz550_600

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * Created by john_liu on 2018/11/23.
  */
class Friend_Circles_547 {
  def findCircleNum(M: Array[Array[Int]]): Int = {
    val visit = ListBuffer.fill(M.length)(0)
    val countList = for (i <- 0 until M.length) yield {
      if (visit(i) == 0) {
        dfsGraph(i, M, visit); 1
      } else 0
    }
    countList.fold(0)(_ + _)
  }

  def dfsGraph(c: Int, M: Array[Array[Int]], visit: mutable.ListBuffer[Int]): Unit = {
    visit(c) = 1
    for(i<-0 to M(c).length) yield{
      if(visit(i) ==0 && M(c)(i) ==1) dfsGraph(i,M,visit)
    }
  }
}
