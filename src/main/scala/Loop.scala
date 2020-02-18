
import org.apache.spark.{SparkConf, SparkContext}

object Loop{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopT")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/BigFuzz-TestPrograms/src/dataset/loop.txt")

    //..... many other code unrelated

    val data = rdd.map{ s =>
      val a = s.split(",")
      for (i <- 1 to a(2).toInt) { //for (i<-1 to 100) {
        a(1) = (a(1).toFloat * (1 + a(3).toFloat)).toString
      }
      (a(0), a(1).toFloat)
    }.filter(l=>l._2>1000000000)
      .map(t=> (t._1,1))
        .reduceByKey(_+_)


    data.collect().foreach(println)

    spark.stop()
  }
}