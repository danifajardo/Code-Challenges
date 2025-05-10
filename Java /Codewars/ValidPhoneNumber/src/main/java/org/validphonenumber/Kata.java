package org.validphonenumber;

public class Kata {

    public static boolean validPhoneNumberRegex(String phoneNumber) {
        //simple solution with regex expressions
        return phoneNumber.matches("\\([\\d]+\\) \\d+-\\d+");
    }

    public static boolean validPhoneNumberStreams(String phoneNumber){
        //pattern to validate a valid phone number
        String pattern = "(n) n-n";
        //convert phoneNumber to pattern and check if it matches
        phoneNumber.chars().mapToObj(
                (sym) -> (char) sym
        ).map( (l) ->{
            if(l >= '0' && l <= '9'){
                return 'n';
            }
            return l;
        }
        ).red;

        return true;
    }

}
