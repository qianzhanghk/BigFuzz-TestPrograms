
import org.apache.spark.{SparkConf, SparkContext}
import java.lang.Float
import scala.math._


object Loop{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopT")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/BigFuzz-TestPrograms/src/dataset/loop.txt")

    //..... many other code unrelated

      val data = rdd.map{ s =>
        var a = s.split(",")
        var tmp = Float.parseFloat(a(1))
        var itr = Integer.parseInt(a(2))
        var rate = Float.parseFloat(a(3))
        //      for (i <- 1 to itr) { //for (i<-1 to 100) {
        //        tmp = tmp * (1 + rate)
        //      }
        var i = 0;
        while(i<itr)
        {
          tmp = tmp*(1+rate)
          i = i+1
        }
        System.out.println(tmp)
        (a(0), tmp)
      }
        .filter(l=> l._2 >1000000000)
        .map(t=> (t._1,1))
        .reduceByKey(_+_)

//      val data = rdd.map{ s =>
//      val a = s.split(",")
//      for (i <- 1 to 100) { //for (i<-1 to 100) {
//        a(2) = (a(2).toFloat * (1 + a(4).toFloat)).toString
//        a(5) = i.toString
//        System.out.println(a(2))
//        if (a(2).toFloat>1000000000) {
//          a(6) = "billionaire"
//        }
//        System.out.println(a(6))
//      }
//      (a(2),a(6))
//    }.filter(s=>s._1.toFloat>0)


    data.collect().foreach(println)

    spark.stop()
  }
}