package chessGameGenerator;

import exceptionHandler.InvalidMoveException;
import piece.ChessPiece;
import piece.ChessPieceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChessBoard {
    public final List<List<ChessSquare>> lsSquare= new ArrayList<>();

    public ChessBoard(){
        Map<Pair,Pair> p= Mapper.getInstance().getMapper();

        for(int i=0; i<8; i++){
            List<ChessSquare> ls = new ArrayList<>();

            for(int j = 0; j<8; j++){
                ls.add(new ChessSquare(i, j));
            }
            lsSquare.add(ls);
        }

        for(Map.Entry<Pair, Pair> entry : p.entrySet()){
            Pair<Integer, Integer> k = entry.getKey();
            Pair<String, String> v = entry.getValue();
            ChessSquare cs = lsSquare.get(k.getFirst()).get(k.getSecond());
            cs.setChessPiece(ChessPieceFactory.getChessPiece(v.getFirst(), v.getSecond(), k.getFirst(), k.getSecond(), this));
            cs.setEmpty();
        }

        for(int i=0; i<8; i++)
        {
            ChessSquare whitePawn = lsSquare.get(1).get(i);
            ChessSquare blackPawn = lsSquare.get(6).get(i);

            whitePawn.setChessPiece(ChessPieceFactory.getChessPiece("pawn", "white", 1, i, this));
            blackPawn.setChessPiece(ChessPieceFactory.getChessPiece("pawn", "black", 6, i, this));

            whitePawn.setEmpty();
            blackPawn.setEmpty();
        }
    }


    public void moveController(ChessSquare src, ChessSquare dest) throws InvalidMoveException{

        int sx= src.getX();
        int sy= src.getY();
        int dx= dest.getX();
        int dy= dest.getY();
        ChessPiece s= src.getChessPiece();
        ChessPiece d= dest.getChessPiece();

        if(!src.isEmpty() && (dest.isEmpty() || !s.getColor().equals(d.getColor())) && s.canMove(dx,dy)){

            s.move(dx,dy);
            dest.setChessPiece(s);

            if(dest.isEmpty())
                dest.setEmpty();

            src.setChessPiece(null);
            src.setEmpty();
        }
        else{
            throw new InvalidMoveException();
        }
    }

    @Override
    public String toString(){
        return "chessGameGenerator.ChessBoard{" +
                "lsSquare=" + lsSquare +
                '}';
    }
}
