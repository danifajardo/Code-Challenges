package com.sha256;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cracker {
    //
    public static String crackSha256(String hash, String chars){
        //
        Integer permutations = getPermutations(chars.length());
        //
        String currentHash = "";
        //
        String shuffleChars = chars;
        //
        for (int i = 0; i < permutations; i++) {
            //
            try {
                //get the hash of this permutation
                currentHash = getSha256(shuffleChars);
                //compare the hashes
                if(compareHash(hash, currentHash)){
                    return shuffleChars;
                }else{
                    //shuffle
                    shuffleChars = shuffleWord(shuffleChars);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //return null (hash can nit be cracken with the current chars)
        return null;
    }

    private static String getSha256(String chars) throws NoSuchAlgorithmException{
        //
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        //
        byte[] digest = sha.digest(chars.getBytes());
        //
        StringBuilder hexString = new StringBuilder();
        //
        for(byte d: digest){
            hexString.append(String.format("%02x", d));
        }
        //
        return hexString.toString();
    }

    private static boolean compareHash(String givenHash, String currentHash){
        //
        try {
            //
            return getSha256(givenHash).equals(currentHash);
        } catch (Exception e) {
            //
            System.out.println("There was a problem with the encrypt algorithm");
            System.out.println(e.getMessage());
        }
        //
        return false;        
    }

    private static Integer getPermutations(Integer stringLength){
        //
        Integer factorial = 1;
        //
        for (int i = 2; i <= stringLength; i++) {
            factorial = factorial*i;
        }
        //
        return factorial;
    }

    private static String shuffleWord(String pastShuffleWord){
        //
        
        return "";
    }
}
