
import org.apache.spark.{SparkConf, SparkContext}

object Loop{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopT")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/loop.txt")

    //..... many other code unrelated

    val data = rdd.map{ s =>
      val a = s.split(",")
      for (i <- 1 to 100) { //for (i<-1 to 100) {
        a(2) = (a(2).toFloat * (1 + a(4).toFloat)).toString
        a(5) = i.toString
        System.out.println(a(2))
        if (a(2).toFloat>1000000000) {
          a(6) = "billionaire"
        }
        System.out.println(a(6))
      }
      a
    }


    data.collect().foreach(println)

    spark.stop()
  }
}