
import org.apache.spark.{SparkConf, SparkContext}

object IntOverflow{

  def main(args: Array[String]) {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Commute")

    val sc = new SparkContext(conf)

    val full_data_type_table = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/zipcode.csv")




    val locations = full_data_type_table.map {
      s =>
        val cols = s.split(",")
        (cols(0), cols(1))
    }
      .filter( s => Integer.parseInt(s._2*20) > 0)

    locations.foreach(println)


  }
}

