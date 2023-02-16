import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TimUoc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer>num = new ArrayList<>();
        for (int i=1; i<= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int temp = n / i;
                if (temp != i) {
                    num.add(i);
                    num.add(temp);
                } else {
                    num.add(i);
                }
            }
        }
        Collections.sort(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
