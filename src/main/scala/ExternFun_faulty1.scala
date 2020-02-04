
import org.apache.spark.{SparkConf, SparkContext}

import scala.math.log

object ExternFun_faulty1{

  def main(args: Array[String]) {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("EXF_faulty")

    val sc = new SparkContext(conf)

    val textFile= sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/ExF.txt")
,



    val wordCounts = textFile
      .flatMap(line => line.split("")).map(word => (word, 1)).reduceByKey(2*_+_)

      .filter{v =>
        System.out.println(v._2)
        val v1 = log(v._2-5)
        v1>1}


  }
}