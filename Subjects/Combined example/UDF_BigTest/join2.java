package edu.ucla.cs.bigfuzz.customarray;

public class join2 {
    String s1, s2;
    float n1;
    public static final join2 apply(String a1, float a2, String a3){

        return new join2(a1, a2, a3);

    }

    public join2(String a1, float a2, String a3){
        s1 = a1;
        n1 = a2;
        s2 = a3;
    }

}

