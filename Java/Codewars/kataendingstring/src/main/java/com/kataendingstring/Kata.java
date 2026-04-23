package com.kataendingstring;

public class Kata {
    //method's solution for the kata
    public static boolean solution(String str, String end){
        //check if the lenght of the end string is greater than the str string
        if (str.length() - end.length() < 0){
            return false;
        }         
        //check if the end string is the same in the end of the str string
        //convert string -> CharacterArray
        char[] strCharacterArray = str.toCharArray();
        char[] endCharacterArray = end.toCharArray();
        //loop throught end character array
        for (int i = 0; i < endCharacterArray.length; i++) {
            //check if any character is different
            if(strCharacterArray[(strCharacterArray.length-endCharacterArray.length)+i] != endCharacterArray[i]){
                //there is at least one different character
                return false;
            }
        }
        //'str' string effectively has 'end' string at its end
        return true;
    }
}
