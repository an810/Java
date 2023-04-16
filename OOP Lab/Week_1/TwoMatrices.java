import java.util.Scanner;

public class TwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the size of matrix: ");
        int n = sc.nextInt();
        int[][] m1 = new int[n][n];
        int[][] m2 = new int[n][n];
        int[][] res = new int[n][n];
        System.out.println("Please enter the first matrix: ");
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                m1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Please enter the second matrix: ");
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                m2[i][j] = sc.nextInt();
                res[i][j] = m1[i][j] + m2[i][j];
            }
        }
        System.out.println("The sum matrix: ");
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
