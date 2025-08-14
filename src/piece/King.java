package piece;

import chessGameGenerator.ChessBoard;

public class King extends AbstractChessPiece {
    private int x;
    private int y;
    private final String pieceName;
    private final String color;

    protected King(String color, int x, int y, ChessBoard chessBoard)
    {
        super(chessBoard);
        this.pieceName= (color.equals("white")? "WK": "BK");
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
        for(int i=0; i<8; i++)
        {
            boolean flag = false;
            for(int j=0; j<8; j++)
            {
                ChessPiece ch= chessBoard.lsSquare.get(i).get(j).getChessPiece();
                if(ch!=null && !ch.getColor().equals(this.color) && ch.getPieceName().equals(this.pieceName))
                {
                    int dx= Math.abs(ch.getX() - x);
                    int dy= Math.abs(ch.getY() - y);
                    if((dx<=1 && dy<=1) && !(dx==0 && dy==0))
                        return false;
                    flag=true;
                    break;
                }
            }
            if(flag)break;
        }

        int dx= Math.abs(this.x-x);
        int dy= Math.abs(this.y-y);

        return (dx<=1 && dy<=1) && !(dx==0 && dy==0);
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
