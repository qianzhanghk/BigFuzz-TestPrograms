import edu.ucla.cs.bigfuzz.customarray.*;
import scala.*;
import java.io.IOException;
import java.util.ArrayList;

public class Loan {
public void Combined(String inputFile) throws IOException {
ArrayList<String> results0 = CustomArray.read(inputFile);
ArrayList< Tuple4>results1 = LoadSpec.Map1(results0);
ArrayList< Tuple2>results2 = LoadSpec.Map2(results1);
ArrayList<String> results3 = CustomArray.read(inputFile);
ArrayList< map3>results4 = LoadSpec.Map3(results3);
ArrayList< map3>results5 = LoadSpec.Filter1(results4);
ArrayList< join2>results6 = LoadSpec.Join1(results5, results2);
ArrayList< map1>results7 = LoadSpec.Map4(results6);
}}
