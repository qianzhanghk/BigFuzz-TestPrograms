import org.apache.spark.{SparkConf, SparkContext}

object OutUDF {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("2flowT")
    val sc = new SparkContext(conf)
    val startTime = System.currentTimeMillis();


    val text = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/salary.csv")

    val data = text.map {
      s =>
        val cols = s.split(",")
        (cols(0), Integer.parseInt(cols(1)), Integer.parseInt(cols(2)))
    }.filter( s => s._1.equals("90024"))


    val pair = data.map {
      s =>
        // Checking if age is within certain range
        if (s._2 >= 40 & s._2 <= 65) {
          ("40-65", s._3)
        } else if (s._2 >= 20 & s._2 < 40) {
          ("20-39", s._3)
        } else if (s._2 < 20){
          ("0-19", s._3)
        } else {
          (">65", s._3)
        }
    }

    println("Time: " + (System.currentTimeMillis() - startTime))
    assert(System.currentTimeMillis()-startTime > 0.1)
  }
}
