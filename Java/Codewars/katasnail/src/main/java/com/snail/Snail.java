package com.snail;

import java.util.Arrays;

public class Snail {
    //
    public static int[] snail(int[][] array){
        //check if the array is not empty
        if(array.length == 0){
            return new int[0];
        }
        //array for return
        int[] sortedArray= new int[array.length*array[0].length];
        int countSortedArray = 0;
        //
        int firstRank = 0;
        int firstColumn = 0;
        int lastColumn = array[0].length-1;
        int lastRank = array.length-1;
        //
        int cursor[] = {firstRank,firstColumn};
        int corner[] = {0, lastColumn};
        //
        int states = 1;
        boolean flag = true;
        //loop throught the array in a snail pattern
        while(flag){
            //look for the states
            if(states == 1){ //going to the right with the fix rank
                //reach the corner
                for(int j = cursor[1]; j < corner[1]; j++){
                    //add elemenst to the sorted array
                    sortedArray[countSortedArray] = array[corner[0]][j];
                    //next position in the sorted array
                    countSortedArray++;
                }
                //
                cursor[0] = corner[0];
                cursor[1] = corner[1];
                //
                corner[0] = lastRank--;
                //next state
                states++;
            }else if(states == 2){ //going down with the column fixed
                //reach the corner
                for(int i = cursor[0]; i < corner[0]; i++){
                    //add elemenst to the sorted array
                    sortedArray[countSortedArray] = array[i][corner[1]];
                    //next position in the sorted array
                    countSortedArray++;
                }
                //
                cursor[0] = corner[0];
                cursor[1] = corner[1];
                //
                corner[1] = firstColumn++;
                //
                //next state
                states++;
            }else if(states == 3){ //doing to the left with the fix rank
                //reach the corner
                for(int j = cursor[1]; j > corner[1]; j--){
                    //add elemenst to the sorted array
                    sortedArray[countSortedArray] = array[cursor[0]][j];
                    //next position in the sorted array
                    countSortedArray++;
                }
                cursor[0] = corner[0];
                cursor[1] = corner[1];
                //
                //  
                corner[0] = ++firstRank;
                //next state
                states++;
            }else if(states == 4){ //going up with the fixed column
                for(int i = cursor[0]; i > corner[0]; i--){
                    //add elemenst to the sorted array
                    sortedArray[countSortedArray] = array[i][corner[1]];
                    //next position in the sorted array
                    countSortedArray++;
                }
                cursor[0] = corner[0];
                cursor[1] = corner[1];
                //
                corner[1] = --lastColumn;
                //initial state
                states = 1;
            }else{}

            if(Arrays.equals(cursor, corner)){
                sortedArray[countSortedArray] = array[cursor[0]][cursor[1]];
                flag = false;
            }

        }
        //
        return sortedArray;
    }

}
