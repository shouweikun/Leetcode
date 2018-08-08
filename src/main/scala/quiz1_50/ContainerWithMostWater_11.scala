package quiz1_50

/**
  * Created by john_liu on 2018/8/8.
  */
object ContainerWithMostWater_11 {
  def maxArea(height: Array[Int]): Int = {
    if(height.size<2) return 0;
     var max:Int = Int.MinValue
     var leftIndex = 0
     var rightIndex = height.size -1
     while(leftIndex<rightIndex){
       max =math.max(max, (rightIndex-leftIndex) * math.min(height(rightIndex),height(leftIndex)))
       if(height(rightIndex)>height(leftIndex)) leftIndex += 1 else rightIndex+= -1
     }
  max
  }

}
