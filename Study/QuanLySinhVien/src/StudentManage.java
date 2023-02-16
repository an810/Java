import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class StudentManage {
    private final static Scanner scanner = new Scanner(System.in);
    private List<Student> students;
    public StudentManage() {
        this.students = new ArrayList<Student>();
    }
    public StudentManage(List<Student> students) {
        this.students = students;
    }
    /**
    * Add student
    */
    public void addStudent(Student student) {
        this.students.add(student);
    }
    /**
     * Print all students
     */
    public void printStudentList() {
        if (!checkEmpty()) {
            for (var s : students) {
                System.out.println("Name: "+ s.getName()+ " DOB: " + s.getDob() + " id: " + s.getId());;
            }
        } else {
            System.out.println("List is empty");
        }

    }
    /**
     * Remove student by id
     * @param id
     */
    public void removeStudent(String id) {
        Iterator itr = students.iterator();
        while (itr.hasNext()) {
            Student s = (Student) itr.next();
            if (id.equals(s.getId())) {
                itr.remove();
                return;
            }
        }
//        for (var s : this.students) {
//            if(s.getId().contains(id)) {
//                this.students.remove(s);
//                return;
//            }
//        }
    }
    /**
     * Find student by id
     * @param id
     */
    public void findStudent(String id) {
        for (var s : this.students) {
            if(s.getId().contains(id)) {
                System.out.println("Name: "+ s.getName()+ " DOB: " + s.getDob() + " id: " + s.getId());
                return;
            }
        }
        System.out.println("Student not found");
    }
    /**
     * Update student by id
     * @param id
     */
    public void updateStudent(String id) {
        for (var s : this.students) {
            if(s.getId().contains(id)) {
                System.out.println("Input changed name:");
                String updateName = scanner.nextLine();
                s.setName(updateName);
                System.out.println("Input changed DOB:");
                String updateDob = scanner.nextLine();
                s.setDob(updateDob);
                return;
            }
        }
        System.out.println("Student not found");
    }

    public String inputName() {
        System.out.print("Input student name: ");
        return scanner.nextLine();
    }

    public String inputId() {
        System.out.print("Input student id: ");
        String inputId = scanner.nextLine();
        while (checkId(inputId)) {
            System.out.println("Invalid id, please enter again: ");
            inputId = scanner.nextLine();
        }
        return inputId;
    }

    public String inputDob() {
        System.out.print("Input student age: ");
        String inputDob = scanner.nextLine();
        return inputDob;
    }

    private boolean checkEmpty() {
        return this.students.isEmpty();
    }
    private boolean checkId(String id) {
        for (var s : this.students) {
            if(s.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }
}

