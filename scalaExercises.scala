object myReduce {
  val c= List(1,3,4,5,6)
  def myReduce(c: List[Int], agg: (Int, Int) => Int) = {
    var total = c(0)
    for(i <- c.tail) {
      total = agg(total, i)
    }
    total
  }

  def main(args: Array[String]): Unit = {
    val v=myReduce(c,(i,j)=>i+j)
    println(v)
  }

}

object sort {
  def main(args: Array[String]): Unit = {
    val path =args(0)
    val orderItems= scala.io.Source.fromFile(path).getLines().toList
    orderItems.
      //sortBy(k=>k.split(",")(0).toInt).reverse.map(i=>i.split(",")(3).toFloat) //?? how to get revenue which is in 4th index
      //sortBy(k=>k.split(",")(1).toInt) //Sort Data in ascending order by category id
      filter(k=>k.split(",")(0).toInt==685) //gives the record with product id 685
      // sortBy(k=>k.split(",")(0).toFloat).reverse //(to sort data in descending order)

      .take(10)
      .foreach(println)

  }

}

import scala.io.Source
object getRevenueList {
  def main(args: Array[String]): Unit = {
    val inputPath=args(0)
    val orderItems: Seq[String] = Source.
      fromFile(inputPath).
      getLines.toList
    val group =orderItems.map(o=>(o.split(",")(1).toInt,
      o.split(",")(4).toFloat)).
      groupBy(k=>k._1).
      filter(l=>l._1==4).
      foreach(println)

    //val groupBy=group.groupBy(k=>k._1)
    //val filter=groupBy.filter(l=>l._1==2).foreach(println)
  }

  }


import scala.io.Source

object getRevenueForOrderId {
  def main(args: Array[String]): Unit = {


    //val inputPath = "C:\\data\\retail_db\\order_items\\part-00000"
    val inputPath =args(0)
    val ordItems = Source.
      fromFile(inputPath).
      getLines.
      toList
     println(getRevenueForOrderId(ordItems,2))

  }


    def getRevenueForOrderId(ord:List[String],id:Int)={
      val ordFilt=ord.filter(o=>o.split(",")(1).toInt==id)
      val ordMap=ordFilt.map(o=>o.split(",")(4).toFloat)
      ordMap.reduce(_ + _) //sum
    }


}
