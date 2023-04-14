import java.util.Scanner;
public class TwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        strNum1 = sc.nextLine();
        double num1 = Double.parseDouble(strNum1);
        System.out.println("Enter the second number: ");
        strNum2 = sc.nextLine();
        double num2 = Double.parseDouble(strNum2);
        System.out.println("The sum of two numbers: " + (num1 + num2));
        System.out.println("The difference of two numbers: " + Math.abs(num1 - num2));
        System.out.println("The product of two numbers: " + (num1 * num2));
        if (num2 != 0) {
            System.out.println("The quotient of two numbers: " + (num1 / num2));
        } else {
            System.out.println("Can not calculate the quotient of two numbers due to value of second number");
        }
    }
}
