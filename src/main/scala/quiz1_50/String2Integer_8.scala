package quiz1_50

/**
  * Created by john_liu on 2018/8/7.
  */
object String2Integer_8 {
  def myAtoi(str: String): Int = {
     lazy val source =  str.split("\\s+")(0).trim.toCharArray.toList
     source match {
       case '-' :: tail =>buildNum(tail,true)
       case _ =>buildNum(source,false)
     }
   def buildNum(charList:List[Char],isNegative:Boolean):Int = {
     val isNum = charList.forall(_.isDigit)
     val num = if(isNum) 0 else {
       charList
         .map(_.toLong)
         .map(x=>if(isNegative)-x else x)
         .fold(0){ (x1,x2)=>x1 *10 * x2}
     }
     if(isNegative)math.max(num,Int.MinValue).toInt else math.min(num,Int.MaxValue).toInt
   }

  }

}
