package Exception;

public class NotAnIntegerException extends Exception {

    public NotAnIntegerException(){
        super("The input should be an integer!");
    }
}
