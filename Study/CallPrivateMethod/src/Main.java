import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        Staff newStaff = new Staff();
        Method callMethod = Staff.class.getDeclaredMethod("privateStaff");
        callMethod.setAccessible(true);
        callMethod.invoke(newStaff);
        
    }
}