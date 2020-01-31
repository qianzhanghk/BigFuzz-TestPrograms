
import org.apache.spark.{SparkConf, SparkContext}

object PathExplosion{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("Path")

    val spark = new SparkContext(conf)

    val data = spark.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/income/part-00000")

    val count = data.map{ s =>
      val cols = s.split(",")
      Integer.parseInt(cols(1))
    }.map{ l=>
      var dis = 1
      var tmp = l

      if(l <= 0){
        dis = 0
      }else {
        while (tmp != 1) {
          if (tmp % 2 == 0) {
            tmp = tmp / 2
          } else {
            tmp = 3 * tmp + 1
          }
          dis = dis + 1
        }
      }
      (l, dis)
    }.foreach(println)
  }
}