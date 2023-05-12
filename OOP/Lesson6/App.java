package Lesson6;

public class App {
    public static void test1() {
        Student s = new Student();
    }

    public static void main(String[] args) {
        System.out.println("Begin");
        test1();
        System.gc();
        System.out.println("End");
    }
}
