
import org.apache.spark.{SparkConf, SparkContext}

object PathExplosion{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("Path")

    val spark = new SparkContext(conf)

    val data = spark.textFile("/home/qzhang/Programs/BigFuzz/dataset/salary1.csv")

    val count = data.map{ s =>
      val cols = s.split(",")
      Integer.parseInt(cols(1))
    }.map{ l=>
      var dis = 1
      var tmp = l

      if(l <= 0){
        dis = 0
      }else {
        System.out.println(tmp)
        while (tmp != 1) {
          if (tmp % 2 == 0) {
            tmp = tmp / 2
          } else {
            tmp = 3 * tmp + 1
          }
          dis = dis + 1
          System.out.println(tmp)
        }
      }
      System.out.println(dis)
      (l, dis)
    }//.foreach(println)
      .filter(m => m._2.equals(25))
      .foreach(println)
  }
}
