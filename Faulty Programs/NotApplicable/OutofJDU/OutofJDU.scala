.map {
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
    }.collect().length

    if (pair>7) {
      System.out.println(pair)
      assert(pair!=8)
    }



filter1 > 1,1
map2 > 1
map3 > "1,"
DAG >filter1-map2:map2-map3
K_BOUND>2
