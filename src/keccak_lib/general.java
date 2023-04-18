package keccak_lib;

import java.math.BigInteger;
import java.util.ArrayList;

public class general {

    static String[] rcstring = {
            "0x0000000000000001",   "0x0000000000008082",   "0x800000000000808A",   "0x8000000080008000",
            "0x000000000000808B",   "0x0000000080000001",   "0x8000000080008081",   "0x8000000000008009",
            "0x000000000000008A",   "0x0000000000000088",   "0x0000000080008009",   "0x000000008000000A",
            "0x000000008000808B",   "0x800000000000008B",   "0x8000000000008089",   "0x8000000000008003",
            "0x8000000000008002",   "0x8000000000000080",   "0x000000000000800A",   "0x800000008000000A",
            "0x8000000080008081",   "0x8000000000008080",   "0x0000000080000001",   "0x8000000080008008"
    };

    static ArrayList<BigInteger> RoundConstants = new ArrayList<>();

    static public void fillRC(){
        for(String number : rcstring){
            RoundConstants.add(new BigInteger(number, 16));
        }
    }

}

