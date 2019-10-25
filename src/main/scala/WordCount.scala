/**
  * Created by Qian on 10/07/19.
  */

import org.apache.spark.{SparkConf, SparkContext}

object WordCount  {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
    conf.setMaster("local[4]")
    conf.setAppName("Wordcount")

    val startTime = System.currentTimeMillis();
    val sc = new SparkContext(conf)

//    val text = sc.textFile(args(0))
    val text = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/words/input")

    text.mapPartitionsWithIndex{
      (partid,iter)=>{
        var part_map = scala.collection.mutable.Map[String,List[Any]]()
        var part_name = "part_" + partid
        part_map(part_name) = List[Any]()
        while(iter.hasNext){
          part_map(part_name) :+= iter.next()//:+= 列表尾部追加元素
        }
        part_map.iterator
      }
    }.collect.foreach(println)

    val words = text.flatMap(line => line.split(" ")).flatMap(l => l.split("\n")).flatMap( ll => ll.split(","))
    val word = words.map(w => (w,1))
    val counts = word.reduceByKey(_ + _)
    counts.foreach(println)
    }
}

