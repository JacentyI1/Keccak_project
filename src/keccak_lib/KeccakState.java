package keccak_lib;

import java.util.Arrays;

/**
 * Keccak state container.
 * The state is stored as a 5x5 table of integers.
 * */
public class KeccakState {
    public static final int W = 5;
    public static final int H = 5;
    private final int bitrate_bytes;
    private Object s;

    int[] rangeW = new int[W];
    int[] rangeH = new int[H];
    public int bitrate;
    public int b;
    public int lanew; //lane width
    public int[][] state;
    KeccakState(int br, int b_2){
        //--Data init
        for(int i = 0; i< W; i++) rangeW[i] = i;
        for(int i = 0; i< H; i++) rangeH[i] = i;
        //ToDo: __init__
        this.bitrate = br;
        this.b = b_2;
        assert ( this.bitrate %8 == 0 );
        this.bitrate_bytes = bits2bytes(bitrate);
        assert ( this.b %25 == 0 );
        this.lanew = this.b; // should be 25
        this.state = KeccakState.zero();
    }
    /**
     * Returns a 5x5 table filled with 0's. */
    public static int[][] zero(){
        int[][] state = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                state[i][j] = 0;
            }
        }
        return state;
    }
    /**
     * Formats the given state as hex, in natural byte order.*/
    public static String format(long[][] st){
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < H; y++) {
            StringBuilder row = new StringBuilder();
            for (int x = 0; x < W; x++) {
                row.append(String.format("%016x", st[x][y])).append(" ");
            }
            sb.append(row.toString().trim()).append("\n");
        }
        return sb.toString().trim();
    }
    /**
     * Converts the lane s to a sequence of byte values,
     * assuming a lane is w bits.*/
    public static byte[] lane2bytes(long s, int w){
        byte[] o = new byte[w/8];
        for (int b = 0; b < w; b += 8) {
            o[b/8] = (byte)((s >> b) & 0xff);
        }
        return o;
    }
    /**
     * Basically reversed lane2bytes. */
    public static long bytes2lane(byte[] b) {
        long s = 0;
        for (int i = 0; i < b.length; i++) {
            s |= ((long) (b[i] & 0xff)) << (8 * i);
        }
        return s;
    }
    public void bytes2str(){
        //ToDo: bytes2str()
    }
    public void str2bytes(){
        //ToDo: str2bytes()
    }
    public String toString(){
        return null; //format(...);
    }
    /**
     * Mixes in the given bitrate-length string to the state.*/
    public void absorb(byte[] bb){
        assert bb.length == bitrate_bytes;

        byte[] padded = Arrays.copyOf(bb, bits2bytes(b - bitrate));
        int i = 0;

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                byte[] padded_temp = {
                        padded[i], padded[i+1], padded[i+2], padded[i+3],
                        padded[i+4], padded[i+5], padded[i+6], padded[i+7],
                };
                this.state[x][y] ^= bytes2lane(padded_temp);
                i += 8;
            }
        }
    }
    /**
     * Returns the number of bytes required to store the x. */
    public int bits2bytes(int x){
//        return (int) Math.ceil( x / 8.00);
        return (x + 7) / 8;
    }
    /**
     * Returns the bitrate-length prefix of the sate to be output.
     * Returns only the prefix of this byte representation that is equal
     * in length to the bitrate of the Keccak hash function.*/
    public byte[] squeeze(){
        byte[] stateBytes = get_bytes();
        return Arrays.copyOfRange(stateBytes, 0, bitrate_bytes);
    }
    /**
     * Convert whole state to a byte string.
     * @return Keccak's state in bytes*/
    public byte[] get_bytes(){
        byte[] out = new byte[bits2bytes(this.b)];
        int i = 0;
        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                byte[] v = lane2bytes(this.state[x][y], lanew);
                System.arraycopy(v, 0, out, i, v.length);
                i += v.length;
            }
        }
        return out;
    }
    /**
     * Set whole state from byte string, which is assumed to be the correct length.*/
    public void set_bytes(byte[] bb){
        int i = 0;
        for (int y = 0; y < this.lanew; y++) {
            for (int x = 0; x < this.lanew; x++) {
                this.state[x][y] = (int) KeccakState.bytes2lane(Arrays.copyOfRange(bb, i, i + 8));
                i += 8;
            }
        }
    }
}

