package com.example;

import java.util.HashMap;

public class HexToRGB {
    //kata method
    public static HashMap<String, Integer> hexStringToRGB(String hex){
        //verify is not null
        if(hex.isEmpty() || hex == null){
            return null;
        }
        //map as result
        HashMap<String, Integer> result = new HashMap<String, Integer>();
        //keys letters for the map
        char[] rgbLetters = {'r', 'g', 'b'};
        //counter for the rgb letters array
        int rgbLettersCouter = 0;
        //skip the first element of the string
        String hexValue = hex.substring(1);
        //get the value for each (R,G,B)
        for (int l = 0; l < hexValue.length(); l = l + (hexValue.length()/rgbLetters.length)) {
            //get the value
            String currentHexValueString = hexValue.substring(l, l + (hexValue.length()/rgbLetters.length));
            //convert the hex string value to integer 
            int currrentHexValueInteger = Integer.parseInt(currentHexValueString, 16);
            //add each value to the respect letter in the map
            result.put(String.valueOf(rgbLetters[rgbLettersCouter]), currrentHexValueInteger);
            //check if the counter is in the correct range
            if(rgbLettersCouter == 2){
                rgbLettersCouter = 0;
            }else{
                rgbLettersCouter++;
            }
        }
        //return the result map
        return result;
    }

    public static HashMap<String, Integer> hexStringToRGB2(String hex) {
        HashMap<String, Integer> rgb = new HashMap<>();
        char [] col = hex.toCharArray();
        int r= 0,g= 0,b = 0;
        for (int i=1; i<hex.length(); i++){
        switch(i){
            case 1: r = 	Character.getNumericValue(col[i]) * 16;break;
            case 2: r =   r + Character.getNumericValue(col[i]);break;
            case 3: g = 	Character.getNumericValue(col[i]) * 16;break;
            case 4: g =   g + Character.getNumericValue(col[i]);break;
            case 5: b = 	Character.getNumericValue(col[i]) * 16;break;
            case 6: b =   b + Character.getNumericValue(col[i]);break;
            }
        }
        rgb.put("r", r);
        rgb.put("g", g);
        rgb.put("b", b);
        return rgb;
    }

}
