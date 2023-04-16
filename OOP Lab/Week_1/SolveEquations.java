import java.util.Scanner;
public class SolveEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Solve the first-degree equation with one varible");
            System.out.println("2. Solve the system of first-degree equations with two variable");
            System.out.println("0. Exit");
            System.out.println("Please choose: ");
            choice = sc.nextInt();
            if (choice == 1) {
                double a, b;
                System.out.println("Please enter a: ");
                a = sc.nextDouble();
                System.out.println("Please enter b: ");
                b = sc.nextDouble();
                if (a == 0) {
                    System.out.println("The equation have no solution");
                } else {
                    System.out.println("The solution of equation: " + (b/a));
                }
            } else if (choice == 2) {
                double a11, a12, b1, a21, a22, b2;
                System.out.println("Please enter the parameter of the first equation: ");
                a11 = sc.nextDouble(); a12 = sc.nextDouble(); b1 = sc.nextDouble();
                System.out.println("Please enter the parameter of the second equation: ");
                a21 = sc.nextDouble(); a22 = sc.nextDouble(); b2 = sc.nextDouble();
                double D, D1, D2;
                D = a11 * a22 - a21 * a12;
                D1 = b1 * a22 - b2 * a12;
                D2 = a11 * b2 - a21 * b1;
                if (D==0) {
                    if (D2 == 0) {
                        System.out.println("This system equation has infinite solutions");
                    } else{
                        System.out.println("This system equation has no solution");
                    }
                } else {
                    System.out.println("The solution of this system equation: " + (D1 / D) + " and " + (D2 / D));
                }
            } else {
                System.out.println("Invalid! Please enter again!");
            }
        } while (choice != 0);
    }
}
