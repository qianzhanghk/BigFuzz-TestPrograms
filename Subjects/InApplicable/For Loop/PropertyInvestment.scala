package edu.ucla.cs.bigfuzz.sparkprogram


import org.apache.spark.{SparkConf, SparkContext}

object PropertyInvestment{

  def main(args: Array[String]) {

    val conf = new SparkConf().setMaster("local").setAppName("LoopF")

    val spark = new SparkContext(conf)


    //val rdd = spark.textFile("/home/Zhejing/Programs/Benchmarks/src/dataset/salaryEx.csv")
    val rdd = spark.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/loop.txt")
    val data = rdd.map{ s=>
      val a = s.split(",")
      (a(2).toFloat,Integer.parseInt(a(3)),a(4).toFloat,a(6))
    }.
      map{s=>
        var a = s._1
      for (i<-1 to s._2) {
        a = a *(1+s._3)
      }
        (a,s._2,s._3,s._4)
    }.filter(s=>s._1>0)
      .map(s=>
        if (s._1<1000000000)
          {
            System.out.println(s._1,s._4)
          }
        else{
          System.out.println(Integer.parseInt(s._1.toString),s._4,"billionaire")
        }
      )



    print(data)

    spark.stop()
  }
}


map4>","
filter3>"",1.0
reduceByKey1> {1,2,3,4}
map2>"",1.0
DAG >reduceByKey1-map2:map2-filter3:filter3-map4
K_BOUND>2
