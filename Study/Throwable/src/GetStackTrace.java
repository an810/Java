public class GetStackTrace {
    public static void main(String[] args) {
        try {
            int i = 10/0;
        } catch (Exception e) {
            StackTraceElement[] trace = e.getStackTrace();
            System.err.println(trace[0].toString());
            System.err.println(trace[0].getClass());
            System.err.println(trace[0].getMethodName());
            System.err.println(trace[0].getFileName());
            System.err.println(trace[0].getLineNumber());
        }
    }
}
