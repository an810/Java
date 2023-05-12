package Lesson6;

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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }



}

