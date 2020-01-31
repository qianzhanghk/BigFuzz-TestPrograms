
import org.apache.spark.{SparkConf, SparkContext}

object Loop_faulty{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopF")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/loop.txt")

    //..... many other code unrelated

    val data = rdd.map{ s =>
      val a = s.split(",")
      for (i <- 1 to 100) { //for (i<-1 to 100) {
        a(2) = (a(2).toFloat * (1 + a(4).toFloat)).toString
        a(9) = i.toString
        if (a(2).toFloat>1000000000) {
          a(10) = "billionaire"
        }
      }
      a
    }


    print(data)

    spark.stop()
  }
}