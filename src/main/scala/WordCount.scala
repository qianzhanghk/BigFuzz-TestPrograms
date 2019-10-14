/**
  * Created by Qian on 10/07/19.
  */

import org.apache.spark.{SparkConf, SparkContext}

object WordCount  {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
//    conf.setMaster("local")
    conf.setAppName("Wordcount")

    val startTime = System.currentTimeMillis();
    val sc = new SparkContext(conf)
    val text = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/input")

    val words = text.flatMap(line => line.split(" ")).flatMap(l => l.split("\n")).flatMap( ll => ll.split(","))
    val word = words.map(w => (w,1))
    val counts = word.reduceByKey(_ + _)
    counts.foreach(println)
    }
}

