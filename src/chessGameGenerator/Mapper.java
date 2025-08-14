package chessGameGenerator;

import java.util.HashMap;
import java.util.Map;

public class Mapper {
    private static final Map<Pair, Pair> mp = new HashMap<>();
    private static Mapper instance;

    private Mapper(){
        mp.put(new Pair(0,0), new Pair("rook", "white"));
        mp.put(new Pair(0,1), new Pair("knight", "white"));
        mp.put(new Pair(0,2), new Pair("bishop", "white"));
        mp.put(new Pair(0,3), new Pair("queen", "white"));
        mp.put(new Pair(0,4), new Pair("king", "white"));
        mp.put(new Pair(0,5), new Pair("bishop", "white"));
        mp.put(new Pair(0,6), new Pair("knight", "white"));
        mp.put(new Pair(0,7), new Pair("rook", "white"));
        mp.put(new Pair(7,0), new Pair("rook", "black"));
        mp.put(new Pair(7,1), new Pair("knight", "black"));
        mp.put(new Pair(7,2), new Pair("bishop", "black"));
        mp.put(new Pair(7,3), new Pair("queen", "black"));
        mp.put(new Pair(7,4), new Pair("king", "black"));
        mp.put(new Pair(7,5), new Pair("bishop", "black"));
        mp.put(new Pair(7,6), new Pair("knight", "black"));
        mp.put(new Pair(7,7), new Pair("rook", "black"));
    }

    public static Mapper getInstance(){
        if(instance == null){
            synchronized (Mapper.class){
                if(instance == null){
                    instance = new Mapper();
                }
            }
        }
        return instance;
    }

    public Map<Pair,Pair> getMapper(){return this.mp;}
}
