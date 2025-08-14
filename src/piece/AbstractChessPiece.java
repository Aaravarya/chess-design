package piece;

import chessGameGenerator.ChessBoard;

public abstract class AbstractChessPiece implements ChessPiece{
    protected ChessBoard chessBoard= null;

    public AbstractChessPiece(ChessBoard chessBoard){this.chessBoard=chessBoard;}

    protected boolean isPathClear(int srcX, int srcY, int destX, int destY)
    {
        int dx= Integer.compare(destX, srcX);
        int dy= Integer.compare(destY, srcY);

        int x= srcX + dx;
        int y= srcY + dy;

        while(x != destX || y!= destY){
            if(chessBoard.lsSquare.get(x).get(y).getChessPiece() != null)
                return false;
            x+= dx;
            y+= dy;
        }
        return true;
    }
}
