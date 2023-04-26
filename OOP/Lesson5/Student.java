package Lesson5;

public class Student {
    private String name;
    private int age;
    private static int cnt = 0;
    private static String university = "HUST";
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        cnt++;
    }

    public static void main(String[] args) {
        Student std1 = new Student("Hung", 20);
        Student std2 = new Student("Nam", 20);

        std1.university = "NEU";
        System.out.println(std2.university);
    }
}

