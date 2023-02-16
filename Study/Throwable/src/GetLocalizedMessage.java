public class GetLocalizedMessage {
    public static void main(String[] args) throws Throwable {
        try {
            exceptionTest();
        } catch (Throwable t) {
            System.out.println(t.getLocalizedMessage());
        }
    }

    public static void exceptionTest() throws Exception {
        System.out.println("Inside exceptionTest() method");
        throw new Exception("Throwing localized message!");
    }
}
