package edu.ucla.cs.bigfuzz.sparkprogram

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

import scala.math.random

object PropertyInvestmentCalcs {
  def main(args: Array[String]) {
    //System.setProperty("hadoop.home.dir", "C:\\Users\\tjoha\\Documents\\spark-1.6.1-bin-hadoop2.6\\hadoop-2.6.4\\bin\\")

    val conf = new SparkConf().setMaster("local[4]").setAppName("Spark Pi")
    //.setJars(List("\\\\TJVRLAPTOP\\IntelliJ\\SBTScalaSparkPi\\target\\scala-2.10\\SBTScalaSparkPi-assembly-0.1.0-SNAPSHOT.jar"))

    val spark = new SparkContext(conf)


    val rdd = spark.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/salary2.csv")


    val data = rdd.map{ s =>
      val a = s.split(",")
      for (i <- 1 to 10) { //for (i<-1 to 100) {
        a(2) = (a(2).toFloat * (1 + 0.2)).toString
        a(9) = i.toString
      }
      (a(2),a(9))
    }.collect().foreach(println)


    print(data)

    spark.stop()
  }
}

//https://stackoverflow.com/questions/36863110/spark-scala-testing-reading-from-text-file-generating-additional-output-and-w