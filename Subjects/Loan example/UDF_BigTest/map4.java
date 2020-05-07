package edu.ucla.cs.bigfuzz.customarray;

import scala.Tuple2;
import scala.Tuple4;
import scala.runtime.BoxesRunTime;

public class map4 {
   public static void main(String[] args) { 
       apply(new Tuple4(1.0,1,1.0,""));
   }


    static final Tuple2 apply(Tuple4 s){
  float a= (float) s._2();
  for (int i=0; i < BoxesRunTime.unboxToInt(s._3()); ) {
    i++;
    a*=1 + (float) s._4();
  }
  return new Tuple2(s._1(),BoxesRunTime.boxToFloat(a));
}
}