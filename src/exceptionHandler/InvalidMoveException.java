package exceptionHandler;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(){
        super("Invalid move attempted !");
    }
    public InvalidMoveException(String message) {
        super(message);
    }
}
