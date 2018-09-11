package tips
import scala.reflect.runtime.{universe => ru}
import scala.reflect.classTag
import scala.reflect.ClassTag
/**
  * Created by john_liu on 2018/9/11.
  */
object temp {
  def getRuntimeClass[T:ClassTag](obj:T)(implicit ctag:ClassTag[T]) = {
    classTag.runtimeClass
  }

  def main(args: Array[String]): Unit = {
    print(getRuntimeClass(List(1)))
  }
}
