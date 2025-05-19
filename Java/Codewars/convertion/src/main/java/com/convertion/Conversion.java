package com.convertion;

public class Conversion {

  public String[] romanLetters = {"I", "V", "X", "L", "C", "D", "M"};
  public Integer[] romanNumbers = {1, 5, 10, 50, 100, 500, 1000};

  public String solution(int n) {
    return separateNumbers(n);
  }
  
  public String separateNumbers(Integer n){
    //variables
    Integer rest = 0;
    String letters = "";
    //
    for(int j = 3; j >= 0; j--){
        //getting the previous amount
        rest = n - (int) (n % Math.pow(10, (int) j));
        //just the tounseds, hudreds, dozens and units;
        n = n - rest;
        //convert rest in roman letters
        letters = letters + convertNumberLetters(rest);
    }
    //
    return letters;
        
  }  
        
    public String convertNumberLetters(Integer n){
    //check if it is zero
    if(n == 0){
      return "";
    }
    //look if the number exist in the array 
    for(int i = 0; i < romanLetters.length; i++){
        if(n.equals(romanNumbers[i])){
            return romanLetters[i];
        }
    }
    //if it is a composite number

    //find the lower number if the numbers is substarct form the list
    //variables 
    Integer lowerNumber = n;
    Integer currentRomanNumber = romanNumbers[romanNumbers.length-1];
    Boolean addition = true;

    //RULES

    for(int j = 0; j < romanNumbers.length; j++){
        

        if(Math.abs(n - romanNumbers[j]) == 1 || Math.abs(n - romanNumbers[j]) == 10 || Math.abs(n - romanNumbers[j]) == 100){
            currentRomanNumber = romanNumbers[j];
            lowerNumber = Math.abs(n - romanNumbers[j]);
            
            if(n - romanNumbers[j] > 0){
                addition = true;
            }else{
                addition = false;
            }
            break;

        }else if(n - romanNumbers[j] > 0){
            currentRomanNumber = romanNumbers[j];
            lowerNumber = n - romanNumbers[j]; 
        }   
    }

    if(addition){
        return convertNumberLetters(currentRomanNumber).concat(convertNumberLetters(lowerNumber));
    }else{
        if(currentRomanNumber <= 10){
            return convertNumberLetters(1).concat(convertNumberLetters(currentRomanNumber));
        }else if(currentRomanNumber > 10 && currentRomanNumber <= 100){
            return convertNumberLetters(10).concat(convertNumberLetters(currentRomanNumber));
        }else{
            return convertNumberLetters(100).concat(convertNumberLetters(currentRomanNumber));
        }
    }
  }
    
}
