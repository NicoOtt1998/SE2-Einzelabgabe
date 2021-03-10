package com.example.se2einzelabgabej;

public class Calculator {

    //a,b,c,d,e,f,g,h,i,j
    //1,2,3,4,5,6,7,8,9,0
    public String makeNewString(String s) {
        char[] cArray = s.toCharArray();
        for (int i = 1; i < s.length(); i+=2) {
            cArray[i] += cArray[i] == 48 ? 58 : 48;
        }
        return new String(cArray);
    }


}
