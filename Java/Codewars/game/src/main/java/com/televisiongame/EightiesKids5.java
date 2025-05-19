package com.televisiongame;

public class EightiesKids5 {

    static String[] wordsForWater = {"water", "wet", "wash"};
    static String[] wordsForSlime = {"i don't know", "slime"};

    public static String bucketOf(String said) {

        //variables to know if  
        boolean water = false;
        boolean slime = false;
        
        //search for any words in the arrays 'wordsForwater'
        for (String word : wordsForWater) {
            if(said.toLowerCase().contains(word)){
                water = true;
            }
        }
        //as well search if any words of 'wordsForSlime' appear
        for (String word : wordsForSlime) {
            if(said.toLowerCase().contains(word)){
                slime = true;
            }
        }

        //verify what kind of liquid will be
        if(water && slime){
            return "sludge";
        }else if(water){
            return "water";
        }else if(slime){
            return "slime";
        }

        //otherwise return 'air'
        return "air";
    }

}
