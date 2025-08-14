package piece;

import chessGameGenerator.ChessBoard;

import java.util.HashMap;
import java.util.Map;

public class ChessPieceFactory {
    private static final Map<String, ChessPieceCreator> registry = new HashMap<>();

    static {
        register("king", King::new);
        register("queen", Queen::new);
        register("bishop", Bishop::new);
        register("knight", Knight::new);
        register("rook", Rook::new);
        register("pawn", Pawn::new);
    }

    public static void register(String pieceName, ChessPieceCreator creator){
        registry.put(pieceName.toLowerCase(), creator);
    }

    public static ChessPiece getChessPiece(String pieceName, String color, int x, int y, ChessBoard chessBoard){
        ChessPieceCreator supplier = registry.get(pieceName);

        if(supplier!=null)
            return supplier.create(color, x, y, chessBoard);

        throw new IllegalArgumentException("Unknown piece name : "+ pieceName);
    }
}
