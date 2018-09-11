package quiz1_50

/**
  * Created by john_liu on 2018/9/10.
  */
object FirstMissingPositive_41 {
  def firstMissingPositive(nums: Array[Int]): Int = {
    if (nums.length == 0) return 1
    var i: Int = 0
    while (i < nums.length) {
      if (nums(i) <= 0 || nums(i) > nums.length || nums(i) == i + 1) i += 1
      else if (nums(nums(i) - 1) != nums(i)) swap(nums, nums(i) - 1, i) else i += 1
    }
    i = 0
    while (nums(i) == i + 1 && i < nums.length) i += 1
    i + 1
  }

  private def swap(nums: Array[Int], i: Int, j: Int) = {
    val temp = nums(i)
    nums(i) = nums(j)
    nums(j) = temp
  }
}
