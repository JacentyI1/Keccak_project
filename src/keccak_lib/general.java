package keccak_lib;

import java.math.BigInteger;
import java.util.ArrayList;

public class general {

    general(){
        RoundConstants = fillRC();
        Masks = fillMasks();
    }


    static ArrayList<Long> RoundConstants = new ArrayList<>(); //init
    /**
     * translates rcstring's data into an ArrayList of BigIntegers and returns this array.
     * */
    static public ArrayList<Long> fillRC(){
        for(String number : rcstring){
            RoundConstants.add(Long.decode(number));
        }
        return RoundConstants;
    }
    static String[] rcstring = {
            "0x0000000000000001",   "0x0000000000008082",   "0x800000000000808A",   "0x8000000080008000",
            "0x000000000000808B",   "0x0000000080000001",   "0x8000000080008081",   "0x8000000000008009",
            "0x000000000000008A",   "0x0000000000000088",   "0x0000000080008009",   "0x000000008000000A",
            "0x000000008000808B",   "0x800000000000008B",   "0x8000000000008089",   "0x8000000000008003",
            "0x8000000000008002",   "0x8000000000000080",   "0x000000000000800A",   "0x800000008000000A",
            "0x8000000080008081",   "0x8000000000008080",   "0x0000000080000001",   "0x8000000080008008"
    };
    static int[][] RotationConstants = {
            {0, 1, 62, 28, 27},
            {36, 44, 6, 55, 20},
            {3, 10, 43, 25, 39},
            {41, 45, 15, 21, 8},
            {18, 2, 61, 56, 14}
    };

    static ArrayList<Long> Masks = new ArrayList<>();
    static public ArrayList<Long> fillMasks(){
        for(int i=1; i<65; i++){
            long temp = (1L << i) - 1;
            Masks.add(temp);
        }
        return Masks;
    }

    static public void bits2bytes(int x){
        //ToDo: returns 'byte' (?)
    }
    /**
     * Circularly rotate 'value' to the left,
     * treating it as a quantity of the given size in bits.
     * @return
     */
    static public long rol(long value, int left, int bits){
        int top = (int) (value >>> (bits - left));
        int bot = (int) ((value & ((1 << (bits - left)) - 1)) << left);
        return bot | top;
    }
    /**
     * Circularly rotate 'value' to the right,
     * treating it as a quantity of the given size in bits.
     * */
    static public BigInteger ror(){
        //ToDo: ror()
        return null;
    }
    /**
     * The Keccak padding function.
     * Returns:
     * */
    static public void multirate_padding(){
        //ToDo: multirate_padding()
    }
    /**
     * This is Keccak-f permutation. It operates on and
     * mutates the passed-in KeccakState. It returns nothing.
     * */
    static public void keccak_f(){
        //ToDo: keccak_f()
    }



}

