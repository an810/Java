import java.lang.Throwable;
public class PrintStackTrace {
    public static void main(String[] args) throws Throwable{
        try {
            int i = 10/0;
        } catch(Throwable e) {
            e.printStackTrace();
            System.err.println("Cause: " + e.getCause());
        }
    }
}
