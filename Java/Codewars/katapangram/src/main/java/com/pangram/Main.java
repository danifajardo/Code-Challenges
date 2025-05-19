package com.pangram;

public class Main {
    public static void main(String[] args) {
        String sentence = "xfbien skqrpt w lvdgy azcm jhuo";
        Long countLetters = sentence.chars()
            .distinct()
            .filter(
                (c) -> {
                    return (c >= 65 && c <= 90) || (c >= 97 && c <= 122); 
                }           
            ).count();
        System.out.println(countLetters);
    }
}