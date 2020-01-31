import org.apache.spark.{SparkConf, SparkContext}


object IntOverflow2_faulty {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Int2F")
    val sc = new SparkContext(conf)

    val textFile = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/Int2.txt")

    val wordCounts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(2147483647*_+_)

    System.out.println(wordCounts.collect().foreach(println))
  }
}
