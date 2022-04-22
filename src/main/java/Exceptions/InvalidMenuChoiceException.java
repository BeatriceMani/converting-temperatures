package Exceptions;

public class InvalidMenuChoiceException extends RuntimeException{
    public InvalidMenuChoiceException() { super();}

    public InvalidMenuChoiceException(String message) {
        super(message);
    }

    public InvalidMenuChoiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
