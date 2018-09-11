package quiz1_50

/**
  * Created by john_liu on 2018/9/10.
  */
object SearchInsertPosition_35 {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    nums.zipWithIndex.toList.dropWhile(x => x._1 < target) match {
      case Nil => nums.size
      case head :: tail => head._2
    }
  }
}
