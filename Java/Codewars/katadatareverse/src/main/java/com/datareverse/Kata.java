package com.datareverse;

/* A stream of data is received and needs to be reversed.

Each segment is 8 bits long, meaning the order of these segments needs to be reversed
, for example:

11111111  00000000  00001111  10101010
 (byte1)   (byte2)   (byte3)   (byte4)
should become:

10101010  00001111  00000000  11111111
 (byte4)   (byte3)   (byte2)   (byte1)
The total number of bits will always be a multiple of 8.

The data is given in an array as such:

[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0] */

public class Kata {

    public static int[] DataReverse (int[] data){
        //calculate how many bytes will be
        int numBytes = data.length/8;
        //declare a matrix of 4x8
        int[][] dataBytes = new int[numBytes][8];
        int[] dataResult = new int[data.length];
        int byteCount = 0;
        //separate in 8 items (1 byte)
        for (int i = 0; i < numBytes; i++) {
            for (int j = 0; j < 8; j++) {
                dataBytes[i][j] = data[byteCount+j];
            }
            //
            byteCount += 8;
        }
        //rearrange backguards
        //reset byte count 
        byteCount = 0;
        //put them toguether again
        for (int i = numBytes-1; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                dataResult[byteCount+j] = dataBytes[i][j];
            }
            byteCount += 8;
        }
        //return the result
        return dataResult;
    }

    public static int[] DataReverse2(int[] data){
        //calculate how many bytes will be
        int numBytes = data.length/8;
        //
        int[] dataResult = new int[data.length];
        int countBit = 0;
        //
        for (int i = numBytes-1; i >= 0; i--) {
            for (int j = i*8; j < (i*8)+8; j++) {
                dataResult[countBit] = data[j];
                countBit++;
            }
        }

        //
        return dataResult;
    } 

}
