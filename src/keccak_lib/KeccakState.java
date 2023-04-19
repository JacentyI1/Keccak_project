package keccak_lib;
/**
 * Keccak state container.
 * The state is stored as a 5x5 table of integers.
 * */
public class KeccakState {
    final int width = 5;
    final int height = 5;
    private Object s;

    public void zero(){
        //ToDo: zero()
    }
    public String format(Object s){
        //ToDo: format()
        return null;
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
    KeccakState(){
        //ToDo: __init__
    }
    public String toString(){
        return format(this.s);
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
