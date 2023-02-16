import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var students = new StudentManage();
        int option;
        do {
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Find student");
            System.out.println("4. Print list student");
            System.out.println("5. Update student");
            System.out.println("6. Exit");
            System.out.println("Select option:");
            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    String name = students.inputName();
                    String dob = students.inputDob();
                    String id = students.inputId();
                    var newStudent = new Student(name, dob, id);
                    students.addStudent(newStudent);
                    break;
                case 2:
                    System.out.println("Enter ID of removing student: ");
                    String removingId = scanner.nextLine();
                    students.removeStudent(removingId);
                    break;
                case 3:
                    System.out.println("Enter ID of finding student: ");
                    String findingId = scanner.nextLine();
                    students.findStudent(findingId);
                    break;
                case 4:
                    students.printStudentList();
                    break;
                case 5:
                    System.out.println("Enter ID of updating student: ");
                    String updatingId = scanner.nextLine();
                    students.updateStudent(updatingId);
                case 6:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (option != 6);
    }

}

