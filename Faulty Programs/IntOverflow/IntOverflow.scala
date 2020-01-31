      .map { s =>
        val cols = s.split(",")
        (cols(0), cols(1))
       }
      .filter{ 
        l => Integer.parseInt(l._2*20) > 0
        }

filter1 > "11.0", "1"
map2 > "90030,10,50009,90030,55,50009,90030,15,500,90024"
DAG >filter1-map2
