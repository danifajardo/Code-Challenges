package com.string_split;

public class StringSplit {

    public static String[] solution(String s){
        //calculate the numbers of divisions of the string
        int divisions = (int) (Math.ceil((double) s.length()/2));
        //create the array with the actual divisions
        String[] pairs = new String[divisions];
        //
        for(int i = 0; i < s.length(); i += 2){
            if(i == s.length()-1){
                pairs[i/2] = String.valueOf(s.charAt(i)) + "_";
            }else{
                pairs[i/2] = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
            }
        }
        return pairs;
    }
}
