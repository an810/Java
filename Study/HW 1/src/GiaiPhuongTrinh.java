import java.util.Scanner;
public class GiaiPhuongTrinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap tham so: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if ( a==0 && b==0 ){
            System.out.println("Phuong trinh vo nghiem");
            System.exit(0);
        } else if (a ==0 && b != 0) {
            System.out.println("Phuong trinh co 1 nghiem la: "+(-c/b));
            System.exit(0);
        }
        double delta = b*b - 4*a*c;
        double x1,x2;
        if (delta <0) {
            System.out.print("Nghiem cua phuong trinh la: ");
            System.out.println("("+ -b + "+i*" + Math.sqrt(-delta) + ")/" + 2*a);
            System.out.println("("+ -b + "-i*" + Math.sqrt(-delta) + ")/" + 2*a);
        } else if (delta == 0) {
            System.out.println("Nghiem cua phuong trinh: " + (-b)/(2*a));
        } else {
            x1 = (-b + Math.sqrt(delta)) / 2*a;
            x2 = (-b - Math.sqrt(delta)) / 2*a;
            System.out.println("Nghiem cua phuong trinh la: " + x1+ " va " + x2);
        }
    }
}