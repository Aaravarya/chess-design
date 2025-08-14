package piece;

import chessGameGenerator.ChessBoard;

public class Pawn extends AbstractChessPiece {
    private int x;
    private int y;
    private final String pieceName;
    private final String color;

    protected Pawn(String color, int x, int y, ChessBoard chessBoard)
    {
        super(chessBoard);
        this.pieceName= (color.equals("white")? "WP": "BP");
        this.color=color;
        this.x=x;
        this.y=y;
    }

    @Override
    public void move(int x, int y)
    {
        this.x=y;
        this.y=y;
    }

    @Override
    public boolean canMove(int x, int y)
    {
        int direction = this.color.equals("white") ? 1: -1;
        int dx= x - this.x;
        int dy= y - this.y;

        if( (Math.abs(dy) == 1 && dx==direction) ||
                dy==0 && dx==direction && chessBoard.lsSquare.get(x).get(y).getChessPiece() == null)
        {
            if(x==0 || x==7)
                chessBoard.lsSquare.get(this.x).get(this.y)
                        .setChessPiece(ChessPieceFactory.
                                getChessPiece("queen", this.color, this.x, this.y, chessBoard));

            return true;
        }

        return false;
    }

    @Override
    public String getColor(){return this.color;}

    @Override
    public int getX(){ return this.x;};

    @Override
    public int getY(){ return this.y;}

    @Override
    public String getPieceName(){ return this.pieceName;}
}
