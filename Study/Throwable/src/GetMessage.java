public class GetMessage {
    public static void main(String[] args) throws Throwable {
        try {
            int i = 10/0;
        } catch(Throwable t) {
            System.out.println(t.getMessage());
        }
    }
}
