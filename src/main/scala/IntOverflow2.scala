import org.apache.spark.{SparkConf, SparkContext}
import math.log

object IntOverflow2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Int2T")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/Int2.txt")

    val wordCounts = textFile.
      flatMap(line => line.split(" ")).
      map(word => (word, 1)).reduceByKey(_ + _)
      .filter { v =>
              val v1 = log(v._2)
              v1 > 1
            }

    System.out.println(wordCounts)
  }
}
