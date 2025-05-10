package org.peacefulyard;

import java.util.ArrayList;
import java.util.List;

public class PeacefulYard {

    private static final char[] Cats = {'L','M', 'R'};

    public static boolean peacefulYard(String[] yard, int minDistance) {
        //
        List<Integer[]> catsFilesAndRanks = getCatsFilesAndRanks(yard);
        //
        if(catsFilesAndRanks.size() >= 2){
            for (int i = 0; i < catsFilesAndRanks.size()-1; i++) {
                //
                for (int j = i; j < catsFilesAndRanks.size(); j++) {
                    if(j != i && getDistanceBetweenCats(catsFilesAndRanks.get(i),catsFilesAndRanks.get(j)) < minDistance){
                        return false;
                    }
                }
                //
            }
        }
        //return true, there is not conflicts
        return true;
    }

    private static int getDistanceBetweenCats(Integer[] posCat1, Integer[] posCat2) {
        return (int) Math.sqrt(Math.pow(posCat2[1]-posCat1[1], 2) + Math.pow(posCat2[0]-posCat1[0], 2));
    }

    private static List<Integer[]> getCatsFilesAndRanks(String[] yard){ //[file, rank]
        //
        List<Integer[]> catFilesAndRanks = new ArrayList<>();
        //
        for (char Cat : Cats){
            //
            for(int i = 0; i < yard.length; i++){
                //
                if(yard[i].contains(Cat+"")){
                    //
                    catFilesAndRanks.add(new Integer[]{i, yard[i].indexOf(Cat)});
                }
            }
        }
        //
        return catFilesAndRanks;
    }

}
