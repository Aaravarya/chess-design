package piece;

import chessGameGenerator.ChessBoard;

@FunctionalInterface
public interface ChessPieceCreator {
    ChessPiece create(String pieceName, int x, int y, ChessBoard chessBoard);
}
