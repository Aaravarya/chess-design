package piece;

import chessGameGenerator.ChessBoard;

public class Knight extends AbstractChessPiece {
    private int x;
    private int y;
    private final String pieceName;
    private final String color;

    protected Knight(String color, int x, int y, ChessBoard chessBoard)
    {
        super(chessBoard);
        this.pieceName= (color.equals("white")? "WH": "BH");
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
        int dx= Math.abs(this.x-x);
        int dy= Math.abs(this.y-y);

        return (dx==2 && dy==1) || (dx==1 && dy==2);
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
