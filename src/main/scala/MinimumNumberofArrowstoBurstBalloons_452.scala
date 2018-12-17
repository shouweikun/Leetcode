import scala.annotation.tailrec

/**
  * Created by john_liu on 2018/12/15.
  */
class MinimumNumberofArrowstoBurstBalloons_452 {
  def findMinArrowShots(points: Array[Array[Int]]): Int = {
    if (points.isEmpty) return 0;
    val sort = points.sortBy(x => x(0))
    var count = 1;

    def recCount(list:List[Array[Int]]):Unit = {
      list match {
        case hd :: tl => {
          var downer: Int = hd(0)
          var upper: Int = hd(1)

          def recBuildUpperAndList(l:List[Array[Int]]): List[Array[Int]] ={
            if(l.isEmpty)return Nil
            if(l.head(0) == downer) {upper = math.min(l.head(1),upper);recBuildUpperAndList(l.tail)}
            else l
          }

          @tailrec
          def recJudge(acc: List[Array[Int]]): List[Array[Int]] = {
            acc match {
              case head :: tail => {
                if(head(0) ==downer) upper = math.min(upper,head(1))
                if(head(0)<=upper) downer = head(0) else count += 1
                if(head(0)<=upper) recJudge(tail) else acc;
              }
              case _ =>  acc
            }
          }
           val theList= recBuildUpperAndList(tl);
          recCount(recJudge(theList))
        }
        case _ =>
      }
    }
    recCount(sort.toList);
    count;
  }

}
