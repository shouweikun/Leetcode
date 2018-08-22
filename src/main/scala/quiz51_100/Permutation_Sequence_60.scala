package quiz51_100

import scala.annotation.tailrec

/**
  * Created by john_liu on 2018/1/7.
  */
object Permutation_Sequence_60 {
  def getPermutation(n: Int, k: Int): String = {
    @tailrec
    def loopBuild(countDown: Int, remainK: Int, acc: List[Int], remainList: List[Int]): List[Int] = {
      countDown match {
        case 1 => acc:::remainList
        case _ => {
          val index = remainK / factorial(countDown-1)
          val num = remainList(index)
          val nextRemainList = remainList
          .filter(x => x !=num)
          val nextCountDown = countDown - 1
          val nextRemainK   = remainK - factorial(countDown-1) * index
          val nextAcc = acc.:+(remainList(index))
          loopBuild(nextCountDown,nextRemainK,nextAcc,nextRemainList)
        }
      }

    }

    //阶乘
    @tailrec
    def factorial(n: Int, acc: Int = 1): Int = {
      n match {
        case 1 => acc
        case _ => {
          factorial(n - 1, acc * n)
        }
      }
    }

    loopBuild(n,k-1,List.empty,(1 to n).toList)
      .mkString
  }

  def main(args: Array[String]): Unit = {
    println(getPermutation(8,36660))
  }
}
