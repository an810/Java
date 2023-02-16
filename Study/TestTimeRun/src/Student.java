import java.util.ArrayList;
import java.util.LinkedList;

public class Student {
    public String name;
    public int age;
    public String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    public void measurementLinkedList() {
        var start = System.nanoTime();
        var students = new LinkedList<Student>();
        for (int i=0; i<1000_000; i++) {
            students.add(createRandomStudent());
        }
        var end = (System.nanoTime() - start);
        System.out.println(end);
    }
    public void measurementArrayList() {
        var start = System.nanoTime();
        var students = new ArrayList<Student>();
        for (int i=0; i<1000_000; i++) {
            students.add(createRandomStudent());
        }
        var end = (System.nanoTime() - start);
        System.out.println(end);
    }
    private Student createRandomStudent() {
        return new Student("",20,"");
    }

    public static void main(String[] args) {
        Student s = new Student("",20,"");
        s.measurementLinkedList();
        s.measurementArrayList();
    }

}
