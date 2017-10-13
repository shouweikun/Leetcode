package quiz1_50

/**
  * Created by john_liu on 2017/10/13.
  */
object twoSum_1 {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    var i = 0
    var re = Array.empty[Int]
    while ( {
      i < nums.length
    }) {
      var j = i + 1
      while ( {
        j < nums.length
      }) {
        if (nums(j) == target - nums(i)) re = Array[Int](i, j)

        {
          j += 1; j - 1
        }
      }

      {
        i += 1; i - 1
      }
    }
    re
  }
}
