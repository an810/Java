import java.util.Arrays;
import java.util.Scanner;
public class NumericArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter number n: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
        }
        Arrays.sort(a);
        System.out.println("The array after sorted: ");
        for (int i=0; i<n; i++) {
            System.out.printf("%d ",a[i]);
        }
        System.out.print("\n");
        double avg = (double)sum/(double)n;
        System.out.println("The sum of array: " + sum);
        System.out.println("The average of array: " + avg);
    }
}
