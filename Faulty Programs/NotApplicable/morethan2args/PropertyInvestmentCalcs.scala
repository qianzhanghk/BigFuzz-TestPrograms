
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import scala.math.random

object PropertyInvestmentCalcs {
  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopF")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/BigFuzz-TestPrograms/src/dataset/loop.txt")
    val data = rdd.map{ l=>
      val a = l.split(",")
      (a(0), a(1).toFloat, Integer.parseInt(a(2)), a(3).toFloat )
    }
    .map{s=>
        var a = s._2
        for (i<-1 to s._3) {
          a = a * (1 + s._4)
        }
        (s._1, a, s._3, s._4)
      }.filter(t => t._3 > 30)
      .map(p=>
        if (p._2 < 1000000000)
          (p._1, p._2, "poor")
        else{
          (p._1, p._2, "billionaire")
        }
      )
        .collect().foreach(println);

    spark.stop()
  }
}


map1>"",1.0,1,1.0
filter2>"",1.0,1,1.0
map3>"",1.0,1,1.0
map4>","
DAG>map1-filter2:filter2-map3:map3-map4

//https://stackoverflow.com/questions/36863110/spark-scala-testing-reading-from-text-file-generating-additional-output-and-w
