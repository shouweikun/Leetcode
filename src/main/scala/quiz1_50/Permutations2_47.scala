package quiz1_50

/**
  * Created by john_liu on 2018/9/12.
  */
object Permutations2_47 {
  def permuteUnique(nums: Array[Int]): List[List[Int]] = {
    val re: collection.mutable.Set[List[Int]] = collection.mutable.Set.empty
    val len = nums.length

    def backTracking(int: Int, source: Array[Int], acc: => List[List[Int]]): Unit = {
      case len => re ++= acc
      case _ => {
        source.map {
          x =>
            lazy val nextAcc = acc.map {
              y => x :: y
            }
//            lazy val nextSource =
        }

      }
    }

    re.toList
  }


  def main(args: Array[String]): Unit = {

  }
}
