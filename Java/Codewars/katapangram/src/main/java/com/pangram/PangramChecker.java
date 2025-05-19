package com.pangram;

/* A pangram is a sentence that contains every single letter of the
 alphabet at least once. For example, the sentence "The quick brown fox 
 jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once 
 (case is irrelevant).

Given a string, detect whether or not it is a pangram.
 Return True if it is, False if not. Ignore numbers and punctuation. */

public class PangramChecker {
    public boolean check(String sentence){
        //use stream to set, filter and count the letters
        Long countLetters = sentence.chars()
            .distinct() //eliminates duplicades
            .filter( //filter just by uper or lower letters
                (c) -> {
                    return (c >= 65 && c <= 90) || (c >= 97 && c <= 122); 
                }           
            ).count(); // count how many letter are
        //verify if there are 27 letters
        if(countLetters >= 26){
            return true;
        }
        //return faslse if is other value
        return false;
    }


}
