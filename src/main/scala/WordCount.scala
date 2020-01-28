/**
  * Created by Qian on 10/07/19.
  */
import org.apache.spark.{SparkConf, SparkContext}
import math.log10

object WordCount  {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local[4]")
    conf.setAppName("Wordcount")

    val logFile = "/home/qzhang/Programs/Benchmarks/src/dataset/words/input"

    val sc = new SparkContext(conf)
//    val lc = new LineageContext(sc)
//    lc.setCaptureLineage(true)

    val file = sc.textFile(logFile)
//    val file = lc.textFile(logFile,4)

        //get the input partition
//        file.mapPartitionsWithIndex{
//          (partid,iter)=>{
//            var part_map = scala.collection.mutable.Map[String,List[Any]]()
//            var part_name = "part_" + partid
//            part_map(part_name) = List[Any]()
//            while(iter.hasNext){
//              part_map(part_name) :+= iter.next()//:+= 列表尾部追加元素
//            }
//            part_map.iterator
//          }
//        }.collect.foreach(println)

    val counts = file.flatMap(line => line.split(","))
      .map(w => (w,1))
      .reduceByKey(_+_)
      .filter{ v =>
        val v1 = log10(v._2)
        v1 > 1
      }
      .collect.foreach(println)
//      .reduce{(a,b) =>
//        val c = log10(a._2)
//        val d = log10(b._2)
//        if (c > d)
//           a
//        else b
//      }

//      .reduceByKey(2147483600*_ + _).collect.foreach(println)
//    val s = counts.collect().length
//    System.out.println(s);
//
//    var i = 0;
//    for (a<-1 to 100)
//    {
//      if (s>10)
//      {
//        i=98/(99-a)
//      }
//    }

//    val wordsort = counts.map(x=>(x._2,x._1)).filter(x=> log10(x._1)>0).sortByKey(ascending = false).map(x=>(x._2,x._1))


    //    val results = counts.filter(_._1 == "a")
//    results.collect().foreach(println)


//    lc.setCaptureLineage(false)

//    val linRdd = results.getLineage()
//    var inputLines = linRdd.goBackAll()
//    inputLines.collect()
//    inputLines.show().foreach(println)
//    inputLines.collect().foreach(println)
  }
}

//    val text = sc.textFile(args(0))
//    val text = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/words/input")


//    //get the input partition
//    text.mapPartitionsWithIndex{
//      (partid,iter)=>{
//        var part_map = scala.collection.mutable.Map[String,List[Any]]()
//        var part_name = "part_" + partid
//        part_map(part_name) = List[Any]()
//        while(iter.hasNext){
//          part_map(part_name) :+= iter.next()//:+= 列表尾部追加元素
//        }
//        part_map.iterator
//      }
//    }.collect.foreach(println)