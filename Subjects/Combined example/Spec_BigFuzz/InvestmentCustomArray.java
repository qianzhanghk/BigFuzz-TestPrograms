package edu.ucla.cs.bigfuzz.customarray;

import edu.berkeley.cs.jqf.instrument.tracing.TraceLogger;
import edu.ucla.cs.bigfuzz.customarray.applicable.CommuteType.join6;
import edu.ucla.cs.bigfuzz.dataflow.*;
import janala.logger.inst.METHOD_BEGIN;
import janala.logger.inst.MemberRef;
import scala.Tuple2;
import scala.Tuple4;

import java.util.*;public class InvestmentCustomArray {

    private ArrayList<Object> list;

    public void CombinedCustomArray() {

    }
 public static ArrayList<Tuple4> Map1(ArrayList<String> result){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList< Tuple4> ans = new ArrayList<>();
        TraceLogger.get().emit(new MapEvent(iid, method, callersLineNumber));
for (String results: result){ans.add( map6.apply( results));}
return ans;
}
 public static ArrayList<Tuple2> Map2(ArrayList< Tuple4> result){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList< Tuple2> ans = new ArrayList<>();
        TraceLogger.get().emit(new MapEvent(iid, method, callersLineNumber));
for ( Tuple4 results: result){ans.add( map4.apply( results));}
return ans;
}
 public static ArrayList< map3> Map3(ArrayList<String> result){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList< map3> ans = new ArrayList<>();
        TraceLogger.get().emit(new MapEvent(iid, method, callersLineNumber));
for (String results: result){ans.add( map3.apply( results));}
return ans;
}
 public static ArrayList< map3> Filter1(ArrayList< map3> result){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList< map3> ans = new ArrayList<>();
for ( map3 results: result){if (filter5.apply(results._1(),results._2()))ans.add(results );}
int arm = 0;
if (!ans.isEmpty()) arm=1;
     TraceLogger.get().emit(new FilterEvent(iid, method, callersLineNumber,arm));
return ans;
}
 public static ArrayList<join2> Join1(ArrayList< map3> result, ArrayList<Tuple2> result0){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList<join2> ans = new ArrayList<>();
        TraceLogger.get().emit(new JoinEvent(iid, method, callersLineNumber));
     for ( Tuple2 results: result0)
         for (map3 results0: result)
         {
             if (results._1().equals(results0._1())){
                 ans.add( join2.apply(results0._1(),(Float) results._2(),results0._1()));}
         }
return ans;
}
 public static ArrayList<map1> Map4(ArrayList<join2> result){
        int callersLineNumber = Thread.currentThread().getStackTrace()[1].getLineNumber();

        int iid = CustomArray.class.hashCode(); // this should be a random value associated with a program location
        MemberRef method = new METHOD_BEGIN(Thread.currentThread().getStackTrace()[1].getClassName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "()V"); // containing method

        ArrayList< map1> ans = new ArrayList<>();
        TraceLogger.get().emit(new MapEvent(iid, method, callersLineNumber));
for ( join2 results: result){ans.add( map1.apply( results.s1,results.n1,results.s2));}
return ans;
}
}