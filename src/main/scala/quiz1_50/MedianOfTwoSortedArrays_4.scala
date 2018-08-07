package quiz1_50

import scala.annotation.tailrec

/**
  * Created by john_liu on 2018/7/17.
  *
  * There are two sorted arrays nums1 and nums2 of size m and n respectively.
  * *
  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  */
object MedianOfTwoSortedArrays_4 {
  def findMedianSortedArrays(nums1: Array[Int], nums2: Array[Int]): Double = {
    lazy val size1 = nums1.size
    lazy val size2 = nums2.size
    lazy val totalSize = size1 + size2
    lazy val goalIndexList: List[Int] = if (totalSize % 2 == 0) List((totalSize / 2), (totalSize / 2 + 1)) else List((totalSize / 2)+1)
    @tailrec
    def loopFind(index1: => Int = 0, index2: => Int = 0, acc: => List[Int] = List.empty, numIndex: Int = 1): Double = {
      lazy val stackTop = numIndex > totalSize  || acc.size == goalIndexList.size

      if (stackTop){
        lazy val sum :Double= acc.map(_.toDouble).fold(0.0d)(_ + _)
        lazy val theSize = acc.size
        sum /  theSize.toDouble
      }
      else {
        lazy val index2IsRunOut = index2 >= size2
        lazy val index1IsRunOut = index1 >= size1
        lazy val pickNums1Element: Boolean = (index1IsRunOut, index2IsRunOut) match {
          case (false, false) => nums1(index1) < nums2(index2)
          case (true, _) => false
          case (_, true) => true
        }
        lazy val nextIndex1 = if (pickNums1Element) index1 + 1 else index1
        lazy val nextIndex2 = if (pickNums1Element) index2 else index2 + 1
        lazy val pickElement = if (pickNums1Element) nums1(index1) else nums2(index2)
        lazy val nextNumIndex = numIndex + 1
        lazy val nextAcc = if (goalIndexList.contains(numIndex)) acc.::(pickElement) else acc
        loopFind(nextIndex1,nextIndex2,nextAcc,nextNumIndex)
      }
    }
    loopFind()
  }

  def main(args: Array[String]): Unit = {
    println(findMedianSortedArrays(Array(1,2),Array(3,4)))
  }
}
