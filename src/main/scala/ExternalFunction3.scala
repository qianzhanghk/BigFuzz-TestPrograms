
import org.apache.spark.{SparkConf, SparkContext}

object ExternalFunction3{

  def main(args: Array[String]) {

    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("ExtT")

    val sc = new SparkContext(conf)

    val textFile = sc.textFile("ExF3.txt")


    val wordCounts = textFile
      .flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(2*_+_).foreach(println)


  }
}