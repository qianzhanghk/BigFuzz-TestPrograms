public class map3 { 
   public static void main(String[] args) { 
       apply("1,");
   }
  static final map3 apply(Tuple3 s){
  return ((s._2()) >= 40) & ((s._2()) <= 65) ? new map3("40-65",s._3()) : ((s._2()) >= 20) & ((s._2()) < 40) ? new map3("20-39",s._3()) : (s._2()) >= 20 ? new map3(">65",s._3()) : new map3("0-19",s._3());
}
String sa,sb;

int ia,ib;
public int _1(){
	return ia;
}
public int _2(){
	return ib;
}
public map3(int k, int v){
        ia = k;
        ib = v;
}
public map3(String k, int v){
        sa = k;
        ib = v;
}
public map3(int k, String v){
        ia = k;
        sb = v;
}
public map3(String k, String v){
        sa = k;
        sb = v;
}}