import java.util.Scanner;

public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter n: ");
        int n = sc.nextInt();
        int space = n-1, val = 1;
        for (int i=1; i<=n; i++) {
            for(int j=1; j<=space; j++) {
                System.out.print(" ");
            }
            for (int j=1; j<=val; j++) {
                System.out.print("*");
            }
            val+=2;space--;
            System.out.println("");
        }
    }
}
