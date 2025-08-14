package piece;

import chessGameGenerator.ChessBoard;

public class Bishop extends AbstractChessPiece {
    private int x;
    private int y;
    private final String pieceName;
    private final String color;

    protected Bishop(String color, int x, int y, ChessBoard chessBoard)
    {
        super(chessBoard);
        this.pieceName= (color.equals("white")? "WB": "BB");
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

        return (dx==dy && dx!=0 && isPathClear(this.x, this.y, x, y));
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
