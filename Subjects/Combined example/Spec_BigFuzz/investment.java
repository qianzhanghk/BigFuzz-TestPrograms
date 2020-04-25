import edu.ucla.cs.bigfuzz.customarray.*;
import scala.Tuple2;
import scala.Tuple4;

import java.io.IOException;
import java.util.ArrayList;


public class investment {
    public static void main(String[] args) throws IOException {
        investment a = new investment();
        a.Combined("/Users/a123/Desktop/BigFuzz-TestPrograms/RandomFuzz_Generated_Inputs/Valid_Seed/A2/Property"
        ,"/Users/a123/Desktop/BigFuzz-TestPrograms/RandomFuzz_Generated_Inputs/Valid_Seed/A2/zipcode");
    }
public void Combined(String inputFile1, String inputFile2) throws IOException {
ArrayList<String> results0 = CustomArray.read(inputFile1);
ArrayList<Tuple4> results1 = InvestmentCustomArray.Map1(results0);
ArrayList<Tuple2> results2 = InvestmentCustomArray.Map2(results1);
ArrayList<String> results3 = CustomArray.read(inputFile2);
ArrayList<map3> results4 = InvestmentCustomArray.Map3(results3);
ArrayList<map3> results5 = InvestmentCustomArray.Filter1(results4);
ArrayList<join2> results6 = InvestmentCustomArray.Join1(results5, results2);
ArrayList<map1> results7 = InvestmentCustomArray.Map4(results6);
}}
