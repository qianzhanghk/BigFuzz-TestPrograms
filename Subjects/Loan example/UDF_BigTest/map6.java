package edu.ucla.cs.bigfuzz.customarray;

import scala.Predef$;
import scala.Tuple4;
import scala.collection.immutable.StringOps;
import scala.runtime.BoxesRunTime;

public class map6 {
   public static void main(String[] args) { 
       apply(",");
   }
  static final Tuple4 apply(String s){
  String a[]=s.split(",");
  return new Tuple4(a[0],BoxesRunTime.boxToFloat((new StringOps(Predef$.MODULE$.augmentString(a[1]))).toFloat()),(Integer.parseInt(a[2])),BoxesRunTime.boxToFloat((new StringOps(Predef$.MODULE$.augmentString(a[3]))).toFloat()));
}
}