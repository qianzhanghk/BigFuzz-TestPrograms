import edu.ucla.cs.bigfuzz.customarray.*;
import scala.Tuple2;
import scala.Tuple4;

import java.io.IOException;
import java.util.ArrayList;

public class Combined {
public void Combined(String inputFile) throws IOException {
ArrayList<String> results0 = CustomArray.read(inputFile);
ArrayList<Tuple4> results1 = CombinedCustomArray.Map1(results0);
ArrayList<Tuple2> results2 = CombinedCustomArray.Map2(results1);
ArrayList<String> results3 = CustomArray.read(inputFile);
ArrayList<map3> results4 = CombinedCustomArray.Map3(results3);
ArrayList<map3> results5 = CombinedCustomArray.Filter1(results4);
ArrayList<join2> results6 = CombinedCustomArray.Join1(results5, results2);
ArrayList<map1> results7 = CombinedCustomArray.Map4(results6);
}}
