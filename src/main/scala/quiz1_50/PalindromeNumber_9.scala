package quiz1_50

/**
  * Created by john_liu on 2018/8/7.
  */
object PalindromeNumber_9 {
  def isPalindrome(x: Int): Boolean = {
     x match {
       case 0 => true
       case x if(x<0) => false
       case x if(x%10==0) => false
       case x => x.toString.reverse.toLong == x.toLong
     }
  }
}
