package chessGameGenerator;

import piece.ChessPiece;

public class ChessSquare {
    private final int x;
    private final int y;
    private boolean isEmpty;
    private ChessPiece chessPiece = null;

    public ChessSquare(int x, int y){
        this.x=x;
        this.y=y;
        this.isEmpty=true;
    }

    public int getX(){return this.x;}
    public int getY(){return this.y;}
    public boolean isEmpty(){return isEmpty;}
    public void setEmpty(){this.isEmpty = !isEmpty;}

    public void setChessPiece(ChessPiece chessPiece){this.chessPiece=chessPiece;}
    public ChessPiece getChessPiece(){return this.chessPiece;}

}
