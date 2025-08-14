import chessGameGenerator.ChessBoard;
import chessGameGenerator.ChessSquare;
import exceptionHandler.InvalidMoveException;
import piece.ChessPiece;

public class PlayChess {
    private final ChessBoard chessBoard;
    private boolean flag=true;

    public PlayChess(){
        chessBoard= new ChessBoard();
        printBoardForWhite();
    }

    public int makeMove(int sx, int sy, int dx, int dy){

        try{
            if(sx < 0 || sx>=8 || sy<0 || sy>=8 || dx<0 || dx>=8 || dy<0 || dy>=8)
                throw new InvalidMoveException();

            ChessSquare s= chessBoard.lsSquare.get(sx).get(sy);
            ChessSquare d= chessBoard.lsSquare.get(dx).get(dy);

            if( (flag && s.getChessPiece().getColor().equals("black")) || (!flag &&
                    s.getChessPiece().getColor().equals("white")))
             throw new InvalidMoveException();

           chessBoard.moveController(s,d);
           System.out.println("Move made !");

           if(!flag)printBoardForWhite();
           else printBoardForBlack();
           flag= !flag;

           if(checkmate())return -1;
           return 1;
        }
        catch (InvalidMoveException e){
            System.out.println(e.getMessage());
            return 0;
        }
    }

    private void printBoardForWhite(){
        for(int i=7; i>=0; i--)
        {
            System.out.print(i + " ");
            for(int j=0; j<=7; j++)
            {
                ChessSquare cs = chessBoard.lsSquare.get(i).get(j);

                if(cs.isEmpty()) System.out.print(" :: ");
                else System.out.print(" "+cs.getChessPiece().getPieceName()+" ");
            }
            System.out.println();
        }

        System.out.print("   ");
        for(int i=0; i<=7; i++)
            System.out.print(i + "   ");
        System.out.println();
    }

    private void printBoardForBlack(){
        for(int i=0; i<8; i++)
        {
            System.out.print(i + " ");
            for(int j=7; j>=0; j--)
            {
                ChessSquare cs = chessBoard.lsSquare.get(i).get(j);

                if(cs.isEmpty()) System.out.print(" :: ");
                else System.out.print(" "+cs.getChessPiece().getPieceName()+" ");
            }
            System.out.println();
        }

        System.out.print("   ");
        for(int i=7; i>=0; i--)
            System.out.print(i + "   ");
        System.out.println();
    }


    private boolean checkmate(){
        boolean WK = false, BK=false;

        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                ChessPiece c= chessBoard.lsSquare.get(i).get(j).getChessPiece();
                if(c!=null && c.getPieceName().equals("WK"))
                    WK=true;

                if(c!=null && c.getPieceName().equals("BK"))
                    BK=true;
            }
        }

        if(WK && !BK)
        {
            System.out.println("Congratulation White won !!!");
            return true;
        }
        else if(!WK && BK)
        {
            System.out.println("Congratulation Black won !!!");
            return true;
        }
        return false;
    }
}
