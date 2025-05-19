package com.piglatin;

public class PigLatin {

    //
    public static String pigIt(String str){
        //variable to store the new phrase
        String finalPhrase = "";
        //word to put in all words at the end
        String endWord = "ay";
        //make an array of strings splitting by space
        String[] arrWords = str.split(" ");
        //for all words put the first letter at the end and add the endWord
        for(int word = 0; word < arrWords.length; word++){
            //is ! just add it 
            if(arrWords[word].equals("!") || arrWords[word].equals("?")){
                finalPhrase += arrWords[word];
            }else{
                //conver the corrent word to an array of characters
                char[] arrCharacters = arrWords[word].toCharArray();
                //store the first letter od the word
                char firstLetter = arrCharacters[0];
                //loop to reorganize the following letters
                for (int i = 0; i < arrCharacters.length-1; i++) {
                    arrCharacters[i] = arrCharacters[i+1];                
                }
                //add the last letter
                arrCharacters[arrCharacters.length-1] = firstLetter;
                //if is
                if(word < arrWords.length-1)
                {
                    //add the end Word and a space
                    finalPhrase += String.valueOf(arrCharacters) + endWord + " ";
                }else{
                    //add the end Word
                    finalPhrase += String.valueOf(arrCharacters) + endWord;
                }
            }
             
        }
        //return the result
        return finalPhrase;
    }


}
