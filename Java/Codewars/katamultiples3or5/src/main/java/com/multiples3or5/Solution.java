package com.multiples3or5;

/* If we list all the natural numbers below 10 that are multiples of 3 or 5,
 we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below
the number passed in.

Note: If the number is a multiple of both 3 and 5, only count it once. */

public class Solution {

    public int solution(int number){
        //store the sum of the multiples of 3 or 5
        Integer sum = 0;
        //look through all the numbers below that number given
        for(int i = 1; i < Math.ceil(number/2); i ++){
            if(i*3 < number ){
                sum += i*3; 
                System.out.println(i*3);  
            }
            
            if(i*5 < number){
                sum += i*5;
                System.out.println(i*5);
            }
        } 
        //return the sum of the numbers
        return sum;
    }

    public int otherSolution(int number){
        //store the sum of the multiples of 3 or 5
      Integer sum = 0;
      //look through all the numbers below that number given
      for(int i = 1; i < number; i++){
          if(i % 3 == 0 || i % 5 == 0){
            sum += i;   
          }
      } 
      //return the sum of the numbers
      return sum;
    }
}
