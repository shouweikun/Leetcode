package quiz1_50

import scala.annotation.tailrec

/**
  * Created by john_liu on 2018/8/23.
  */
object _3Sum_15 {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    loopFind(nums.toList)
  }

  @tailrec
  def loopFind(nums: => List[Int], acc: => Set[List[Int]] = Set.empty): List[List[Int]] = {
    nums match {
      case x1 :: tail if (tail.size >= 2) => {
        lazy val nextAcc = acc ++ find2(tail).withFilter {
          case (x2, x3) => x1 + x2 + x3 == 0
        }.map {
          case (x2, x3) => List(x1, x2, x3).sorted
        }
        loopFind(tail, nextAcc)
      }
      case _ => acc.toList
    }

    @tailrec
    def find2(list: List[Int], acc: => List[(Int, Int)] = Nil): Set[(Int, Int)] = {
      list match {
        case x1 :: tail if (tail.nonEmpty) => {
          lazy val nextAcc = acc ::: tail.map(x => (x1, x))
          find2(tail, nextAcc)
        }
        case _ => acc.toSet
      }
    }
  }


  def threeSum2(nums: Array[Int]): List[List[Int]] = {

    @tailrec
    def loop(num: List[Int], acc: => List[List[Int]] = List.empty): List[List[Int]] = {
      num match {
        case head :: tail if (tail.size >= 2) => {
          @tailrec
          def theLoop(list: => List[Int], theAcc: => List[List[Int]] = Nil): List[List[Int]] = {
            list match {
              case theHead :: theTail if (theTail.nonEmpty) => {
                lazy val expectedValue = 0 - (theHead + head)
                lazy val currentList: List[Int] = if (theTail.contains(expectedValue)) List(head, theHead, expectedValue) else Nil
                lazy val nextTheAcc = currentList :: theAcc
                theLoop(theTail, nextTheAcc)
              }
              case _ => theAcc
            }
          }

          loop(tail, acc ::: theLoop(tail))
        }
        case _ => acc.distinct

      }
    }

    loop(nums.toList.sorted)
  }



  def main(args: Array[String]): Unit = {
    val arr = Array(-1, 0, 1, 2, -1, -4)
    println(threeSum(arr))
    println(threeSum2(arr))

  }
}
