package quiz1_50

/**
  * Created by john_liu on 2017/10/13.
  */
object Permutations_46 {
  def permute(nums: Array[Int]): List[List[Int]] = {
    val length = nums.length
    def start(n: Int, list: List[List[Int]] = List(Nil)):List[List[Int]] = {
      list.map {
        thelist =>
          thelist match {
            case l if (l.isEmpty) => List(List(n))
            case notempty => func(notempty, n)
          }

      }.fold(List.empty)((a1,a2) =>a1 ++ a2)
    }

    def func(list: List[Int], n: Int): List[List[Int]] = {


      def loop(looplist: List[Int], Increnment: List[Int] = Nil, re: List[List[Int]] = List.empty): List[List[Int]] = {
        looplist match {
          case Nil => re.+:(list ++ List(n) )
          case head :: tail => {
            val nextIncrement = Increnment ++ List(head)
            val nextLooplist = tail
            val nextRe = re.+:(Increnment ++ List(n) ++ looplist)
            loop(nextLooplist, nextIncrement, nextRe)
          }
        }


      }
      loop(list)
    }


    def theloop(i:Int,re: List[List[Int]] = List(Nil)):List[List[Int]] ={

      i match {
        //case 0              =>theloop(1,start(nums(0)))
        case i if(i<length) =>theloop(i+1,start(nums(i),re))
        case length         =>re
      }
    }

    theloop(0).sortWith{
      (x1,x2) =>
        var one =Array.empty[Int]
        var minusone = Array.empty[Int]
        (0 until x1.length).foreach{
          i =>if(x1(i)<x2(i)){
            one =one ++ Array(i)
          }else{
            if(x1(i)>x2(i))minusone = minusone ++ Array(i)
          }
        }
        val flag =if(one.isEmpty){false}else{
          if(minusone.isEmpty)true else if(one(0)<minusone(0)) true else false
        }

        flag
    }

  }
}
