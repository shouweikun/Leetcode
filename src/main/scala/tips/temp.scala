package tips


import scala.reflect.runtime.{universe => ru}
import scala.reflect.classTag
import scala.reflect.ClassTag

/**
  * Created by john_liu on 2018/9/11.
  */
object temp {
  def getRuntimeClass[T](obj: T)(implicit ctag: ClassTag[T]) = {
    classTag.runtimeClass
  }

  def getTypeTag[T:ru.TypeTag](obj: T) = ru.typeTag[T]

  def main(args: Array[String]): Unit = {
    println(getTypeTag(List(1)).tpe.toString)
    print(getRuntimeClass(List(1)))
  }
}
