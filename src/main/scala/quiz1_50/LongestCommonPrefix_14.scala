package quiz1_50

/**
  * Created by john_liu on 2018/8/23.
  */
object LongestCommonPrefix_14 {
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.length == 0) return ""
    var common: String = strs(0)
    strs.takeWhile {
      str =>
        common = findLongestCommonPrefixBetween2(str, common)
        common.nonEmpty
    }
    common
  }

  def findLongestCommonPrefixBetween2(str1: String, str2: String): String = {
    str1
      .zip(str2)
      .takeWhile {
        case (x1, x2) => x1 == x2
      }.map(x => x._1)
      .mkString
  }
}
