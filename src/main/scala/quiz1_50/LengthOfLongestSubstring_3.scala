package quiz1_50

/**
  * Created by john_liu on 2018/7/16.
  */
object LengthOfLongestSubstring_3 {
  def lengthOfLongestSubstring(s: String): Int = {
    lazy val charSequence = s.toCharArray
    lazy val size = charSequence.size
    def loopCompare(acc: =>Map[Char,Int]= Map.empty,longest:Int = 0,upper:Int =0,down:Int = 0):Int = {
       lazy val stackTop = upper >= size
       if(stackTop) longest
       else {
         lazy val currentChar  = charSequence(upper)
         lazy val indexInMap = upper +1
         lazy val nextDown = if(acc.contains(currentChar)) math.max(down,acc(currentChar)) else down
         lazy val nextLongest = math.max(longest,indexInMap -nextDown)
         lazy val nextAcc = acc.+(currentChar->indexInMap)
         lazy val nextUpper = upper +1
         loopCompare(nextAcc,nextLongest,nextUpper,nextDown)
       }
    }

    loopCompare()


  }


}
