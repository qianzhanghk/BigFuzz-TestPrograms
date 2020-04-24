      // Trips
      val trips = sc.textFile(
        "/home/qzhang/Programs/eclipse/Test-Minimization-in-Big-Data-JPF-integrated/benchmarks/src/datasets/trips/*")
      .map { line1 =>
        val cols = line1.split(",")
        (cols(0),cols(1).toFloat, Integer.parseInt(cols(2)), cols(3).toFloat)
      }.map{s=>
        var a = s._2
        for (i<-1 to s._3) {
          a = a *(1+s._4)
        }
        (s._1,a)
      }
    val locations = sc.textFile(
        "/home/qzhang/Programs/eclipse/Test-Minimization-in-Big-Data-JPF-integrated/workspace/up_jpf/benchmarks/src/datasets/zipcode/*")
      .map { line2 =>
        val cols = line2.split(",")
        (cols(0), cols(1))
      }
     .filter{v =>
       val t1 = v._1
       val t2 = v._2
       t2.equals("Palms")}
   val joined = trips.join(locations)
   joined
     .map { s =>
        // Checking if speed is < 25mi/hr
        if (s._2._1 > 40) {
          ("rich", 1)
        } else if (s._2._1 > 15) {
          ("poor", 1)
        } else {
          ("homeless", 1)
        }
      }


