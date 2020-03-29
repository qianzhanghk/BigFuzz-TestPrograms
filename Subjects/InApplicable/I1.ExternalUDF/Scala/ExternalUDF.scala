  def f(s: String): String = {
    return s;
  }



      .map{s=>
      val a = s.split(",")
      (f(a(0)),Integer.parseInt(a(1)))
    }.filter(t => t._2 > 10)



filter3>"",1
map2>","
DAG >filter1-map2
