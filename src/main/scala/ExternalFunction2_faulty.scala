
import org.apache.spark.{SparkConf, SparkContext}

object ExternalFunction2_faulty{

  def main(args: Array[String]) {
    val conf = new SparkConf()
    conf.setMaster("local")
    conf.setAppName("Commute")

    val sc = new SparkContext(conf)

    val full_data_type_table = sc.textFile("/home/qzhang/Programs/Benchmarks/src/dataset/ExF.txt")




    val locations = full_data_type_table.map {
      s =>
        val cols = s.split(",")
        (cols(0), cols(1))
    }
      .filter{
        s =>
          assert(Integer.parseInt(s._2)>10000)
          Integer.parseInt(s._2) > 0}

    locations.foreach(println)


  }
}


/* *
However, same issue occurs in TiDB and MySQL:
SQL:

select tp_int from full_data_type_table where tp_bigint * 20 > 0
TiDB:

ERROR 1105 (HY000): other error: unknown error Overflow

Caused by: com.pingcap.tikv.exception.TiClientInternalException: Error reading region
  at com.pingcap.tikv.operation.SelectIterator.readNextRegion(SelectIterator.java:148)
  at com.pingcap.tikv.operation.SelectIterator.hasNext(SelectIterator.java:161)
  at org.apache.spark.sql.tispark.TiRDD$$anon$2.hasNext(TiRDD.scala:75)
  at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:408)
  at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:408)
  at scala.collection.Iterator$$anon$11.hasNext(Iterator.scala:408)
  at org.apache.spark.shuffle.sort.BypassMergeSortShuffleWriter.write(BypassMergeSortShuffleWriter.java:126)
  at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:96)
  at org.apache.spark.scheduler.ShuffleMapTask.runTask(ShuffleMapTask.scala:53)
  at org.apache.spark.scheduler.Task.run(Task.scala:99)
  at org.apache.spark.executor.Executor$TaskRunner.run(Executor.scala:322)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
  at java.lang.Thread.run(Thread.java:748)
Caused by: java.util.concurrent.ExecutionException: com.pingcap.tikv.exception.SelectException: unknown error Codec(Other(StringError("I64(4355836469450447576) * I64(16) overflow")))
  at java.util.concurrent.FutureTask.report(FutureTask.java:122)
  at java.util.concurrent.FutureTask.get(FutureTask.java:192)
  at com.pingcap.tikv.operation.SelectIterator.readNextRegion(SelectIterator.java:145)
  ... 13 more
Caused by: com.pingcap.tikv.exception.SelectException: unknown error Codec(Other(StringError("I64(4355836469450447576) * I64(16) overflow")))
  at com.pingcap.tikv.region.RegionStoreClient.coprocessorHelper(RegionStoreClient.java:192)
  at com.pingcap.tikv.region.RegionStoreClient.coprocess(RegionStoreClient.java:185)
  at com.pingcap.tikv.operation.SelectIterator.createClientAndSendReq(SelectIterator.java:130)
  at com.pingcap.tikv.operation.SelectIterator.lambda$submitTasks$2(SelectIterator.java:113)
  at java.util.concurrent.FutureTask.run(FutureTask.java:266)
  at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
  at java.util.concurrent.FutureTask.run(FutureTask.java:266)
 */

