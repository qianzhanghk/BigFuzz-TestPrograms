/**
  * Created by malig on 3/27/18.
  * Modified by Qian on 10/07/19.
  */

import org.apache.spark.{SparkConf, SparkContext}

object IncomeAggregate  {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Income")

    val startTime = System.currentTimeMillis();
    val sc = new SparkContext(conf)
    val text = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/salary.csv")

    try{
      val sum = text.map{
        line =>
          if (line.substring(0, 1).equals("$")) {
            val i = line.substring(1)
            i
          } else {
            line
          }
      }
        .map( p => Integer.parseInt(p))
        .filter( r => r < 300)
        .reduce(_ + _)
      println(sum)
    }
    catch {
      case e : Exception =>
        e.printStackTrace()
    }

    println("Time: " + (System.currentTimeMillis() - startTime))
  }
}
