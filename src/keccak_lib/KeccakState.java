package keccak_lib;
/**
 * Keccak state container.
 * The state is stored as a 5x5 table of integers.
 * */
public class KeccakState {
    public static final int W = 5;
    public static final int H = 5;
    private Object s;

    int[] rangeW = new int[W];
    int[] rangeH = new int[H];

    KeccakState(){
        //--Data init
        for(int i = 0; i< W; i++) rangeW[i] = i;
        for(int i = 0; i< H; i++) rangeH[i] = i;
        //ToDo: __init__

    }
    /**
     * Returns a 5x5 table filled with 0's. */
    public static int[][] zero(){
        //ToDo: zero()
        int[][] state = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                state[i][j] = 0;
            }
        }
        return state;
    }
    /**
     * */
    public String format(long[][] st){
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
    public void lane2bytes(){
        //ToDo: lane2bytes()
    }
    public void bytes2lane(){
        //ToDo: butes2lane()
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
    public void absorb(){
        //ToDo: absorb()
    }
    /**
     * Returns the bitrate-length prefix of the sate to be output.*/
    public void squeeze(){
        //ToDo: squeeze()
    }
    /**
     * Convert whole state to a byte string.*/
    public void get_bytes(){
        //ToDo: get_bytes()
    }
    /**
     * Set whole state from byte string, which is assumed to be the correct length.*/
    public void set_bytes(){
        //ToDo: set_bytes()
    }
}
