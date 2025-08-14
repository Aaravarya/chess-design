package piece;

import chessGameGenerator.ChessBoard;

public class Rook extends AbstractChessPiece {
    private int x;
    private int y;
    private final String pieceName;
    private final String color;

    protected Rook(String color, int x, int y, ChessBoard chessBoard)
    {
        super(chessBoard);
        this.pieceName= (color.equals("white")? "WR": "BR");
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
        return (this.x==x || this.y==y) && !(this.x==x && this.y==y) && isPathClear(this.x, this.y, x, y);
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
