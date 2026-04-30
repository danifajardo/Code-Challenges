package com.katasalesman;

public class Travel {
    public static String travel(String r, String zipcode) {
        //split the string by commas
        String[] addresses = r.split(",");
        //String result
        StringBuilder result = new StringBuilder();
        //String street and town list
        StringBuilder streetAndTownList = new StringBuilder();
        //String house number list 
        StringBuilder houseNumberList = new StringBuilder();
        //loop throught addresses
        for (String address : addresses) {
            //check if the zipcode is equals 
            if(address.substring(address.length()-8).equals(zipcode)){
                //check if there is not the first entry to the streetAndTownList
                if(streetAndTownList.length() > 0){
                    streetAndTownList.append(",").append(address.substring(address.indexOf(" "),address.length()-8).trim());
                }else{
                    streetAndTownList.append(address.substring(address.indexOf(" "),address.length()-8).trim());
                }
                //check if there is not the first entry to the houseNumberList
                if(houseNumberList.length() > 0){
                    houseNumberList.append(",").append(address.substring(0, address.indexOf(" ")).trim());
                }else{
                    houseNumberList.append(address.substring(0, address.indexOf(" ")).trim());
                }
            }
        }
        //set the final result
        result.append(zipcode)
              .append(":")
              .append(streetAndTownList)
              .append("/")
              .append(houseNumberList);
        //return the result
        return result.toString();
    }
}
