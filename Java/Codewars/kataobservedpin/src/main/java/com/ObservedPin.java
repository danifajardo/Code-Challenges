package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ObservedPin {
    
    //keyboard layout
    final static char[][] keyboard = {
        {'1', '2', '3'},
        {'4', '5', '6'},
        {'7', '8', '9'},
        {'*', '0', '*'}
    };

    public static List<String> getPINs(String observed){        
        //index variables
        int currentRow = 0, currentCol = 0;
        //char array of the observed pin
        char[] arrayObserved = observed.toCharArray();
        //char array for possible pins
        List<List<Character>> keyAndNeighborsList = new ArrayList<>();
        //List<String> for the result
        List<String> result = new ArrayList<String>();
        //set the pin observed as a first entry in the list
        //result.add(observed);
        //go throught the PIN observed locate it in the keyboard
        for (int i = 0; i < arrayObserved.length; i++) {
            //search for the current key, row and col
            //search loops
            SEARCHKEY: for(int row = 0; row < keyboard.length; row++){
                for(int col = 0; col < keyboard[0].length; col++){
                    if(keyboard[row][col] == arrayObserved[i]){
                        //set current row and col values
                        currentCol = col;
                        currentRow = row;
                        //break the loop of search
                        break SEARCHKEY;
                    }
                }
            }
            //get the neighbor for each key
            keyAndNeighborsList.add(getKeyAndNeighbors(currentRow, currentCol));
        }
        //get all permutation from the key and all its neighbors
        result = allPermutations(keyAndNeighborsList, 0);
        //return the result
        return result;
    }

    private static List<Character> getKeyAndNeighbors(int row, int col){
        //result list
        List<Character> result = new ArrayList<>();
        //search for the neighbors
        int top = row - 1;
        int bottom = row + 1;
        int left = col - 1;
        int right = col + 1;
        //add the key located at row and col
        result.add(keyboard[row][col]);
        //check the top
        if(top >= 0){
            result.add(keyboard[top][col]);
        }
        //check the bottom
        if(bottom < keyboard.length){
            result.add(keyboard[bottom][col]);
        }
        //check the left side
        if(left >= 0){
            result.add(keyboard[row][left]);
        }
        //check the right side
        if(right < keyboard[0].length){
            result.add(keyboard[row][right]);
        }
        //
        return result;
    }

    private static List<String> allPermutations(List<List<Character>> keyAndNeighborsList, int index){
        //
        List<String> result = new ArrayList<>();
        //
        StringBuilder permutation = new StringBuilder();
        //
        //int nextKeyAngNeighborList = 0;
        //
        for (int i = 0; i < keyAndNeighborsList.size(); i++) {
            //
            for (int j = 0; j < keyAndNeighborsList.get(i).size(); j++) {
                //
                permutation.append(String.valueOf(keyAndNeighborsList.get(i).get(j)));
                //
                for (int k = 0; k < keyAndNeighborsList.size(); k++) {
                    //
                    if(i != k){
                        //
                        for (int l = 0; l < keyAndNeighborsList.get(k).size(); l++) {
                            //
                            permutation.append(String.valueOf(keyAndNeighborsList.get(k).get(l)));
                        }
                    }
                }
                //
                result.add(permutation.toString());
                //
                permutation = new StringBuilder();
            }
        }
        //
        return result;
    }

    private static List<String> allPermutations2(List<List<Character>> keyAndNeighborsList, int index){
        List<String> result = new ArrayList<>();
        StringBuilder permutation = new StringBuilder();
        
        if(index + 1 == keyAndNeighborsList.size()-1){
            return result;
        }

        for (Character keyParent : keyAndNeighborsList.get(index)) {
            permutation.append(String.valueOf(keyParent));
            for(Character keyChild : keyAndNeighborsList.get(index+1)){

                permutation.append(String.valueOf(keyChild));
            }
        }

        return result;
    }

}
