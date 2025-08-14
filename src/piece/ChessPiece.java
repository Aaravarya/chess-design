package piece;

public interface ChessPiece {
    void move(int x, int y);
    boolean canMove(int x, int y);
    String getColor();
    int getX();
    int getY();
    String getPieceName();
}
