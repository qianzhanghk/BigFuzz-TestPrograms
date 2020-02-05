      .map{ s =>
      val a = s.split(",")
      for (i <- 1 to 100) { //for (i<-1 to 100) {
        a(2) = (a(2).toFloat * (1 + a(4).toFloat)).toString
        a(5) = i.toString
        System.out.println(a(2))
        if (a(2).toFloat>1000000000) {
          a(6) = "billionaire"
        }
        System.out.println(a(6))
      }
      (a(2),a(6))
    }.filter(s=>s._1.toFloat>0)


filter1 > "",""
map2 > ","
DAG >filter1-map2
K_BOUND>2
