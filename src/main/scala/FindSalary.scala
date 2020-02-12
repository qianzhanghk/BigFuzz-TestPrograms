import org.apache.spark.{SparkConf, SparkContext}

object FindSalary {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local[6]")
    conf.setAppName("Income")

    val startTime = System.currentTimeMillis();
    val sc = new SparkContext(conf)

    val text = sc.textFile("/home/qzhang/Programs/BigFuzz-TestPrograms/src/dataset/number.csv")

    val salary = text.map {
        line =>
          if (line.substring(0, 1).equals("$")) {
            var i = line.substring(1, 6)
            i
          } else {
            line
          }
      }
      .map(p => Integer.parseInt(p))
      .filter(r => r < 300)
      .reduce(_ + _)
      println(salary)
  }
}
