import java.util.Scanner;
public class SolveEquations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Solve the first-degree equation with one varible");
            System.out.println("2. Solve the system of first-degree equations with two variable");
            System.out.println("3. Solve the second-degree equation with one variable");
            System.out.println("0. Exit");
            System.out.println("Please choose: ");
            choice = sc.nextInt();
            if (choice == 1) {
                double a, b;
                System.out.println("Please enter a and b: ");
                a = sc.nextDouble(); b = sc.nextDouble();
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
            } else if (choice == 3) {
                double a, b, c;
                System.out.println("Please enter 3 parameters: ");
                a = sc.nextDouble(); b = sc.nextDouble(); c = sc.nextDouble();
                while (a==0) {
                    System.out.println("Invalid a. Please enter again: ");
                    a = sc.nextDouble();
                }
                double delta = b*b - 4*a*c;
                if (delta < 0) {
                    System.out.println("The equation has no solution");
                } else if (delta == 0) {
                    System.out.println("The equation has one solution: "+ -b/(2*a));
                } else {
                    double x1= (-b + Math.sqrt(delta))/(4*a);
                    double x2 = (-b - Math.sqrt(delta))/(4*a);
                    System.out.println("The equation has two solution: "+ x1 + " and " + x2);
                }

            } else {
                System.out.println("Invalid! Please enter again!");
            }
        } while (choice != 0);
    }
}
