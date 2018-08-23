package quiz1_50

/**
  * Created by john_liu on 2018/8/22.
  */
object IntegerToRoman_12 {
  def intToRoman(num: Int): String = {
    var iterNum = num
    val thousand = iterNum / 1000
    iterNum = (iterNum - 1000 * thousand)
    val hundred = iterNum / 100
    iterNum = (iterNum - 100 * hundred)
    val decade = iterNum / 10
    iterNum = iterNum - 10 * decade
    val unit = iterNum

    List(unit, decade, hundred, thousand)
      .zipWithIndex
      .map(kv => parseNum(kv._1, kv._2 + 1))
      .reverse
      .fold("")(_ + _)
  }

  def parseNum(num: Int, carry: Int): String = {
    lazy val characterArray = carry match {
      case 1 => Array("I", "V", "X")
      case 2 => Array("X", "L", "C")
      case 3 => Array("C", "D", "M")
      case 4 => Array("M", "M", "M")
    }
    lazy val one = characterArray(0)
    lazy val five = characterArray(1)
    lazy val ten = characterArray(2)
    num match {
      case 0 => ""
      case 1 => one
      case 2 => one + one
      case 3 => one + one + one
      case 4 => one + five
      case 5 => five
      case 6 => five + one
      case 7 => five + one + one
      case 8 => five + one + one + one
      case 9 => one + ten
    }
  }
}
