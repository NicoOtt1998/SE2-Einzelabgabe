package com.example.se2einzelabgabej;

public class Calculator {

    //a,b,c,d,e,f,g,h,i,j
    //1,2,3,4,5,6,7,8,9,0
    public String makeNewString(String s){
        String stringNEw="";
        for(int i=0;  i<s.length();i++){
            char c = s.charAt(i);
            if(i%2 != 0){
                if(c==48){
                    c+=58;
                }
                else{
                    c+=48;
                }
            }
            stringNEw+=c;
        }
        return stringNEw;
    }

}