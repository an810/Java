package hust.soict.globalict.aims.exception;
import java.lang.Exception;
public class PlayerException extends Exception {
    public PlayerException() {
        super();
    }

    public PlayerException(String s) {
        super();
        System.err.println(s);
    }
}
