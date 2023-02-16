
import java.util.Scanner;
public class CheckDoiXung {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String str = scanner.nextLine();
        if (str.length() % 2 != 0) {
            System.out.println("Chuoi khong doi xung");
        } else {
            boolean check = true;
            int index = 0;
            int middle = str.length() >> 1;
            while(index < middle && (str.charAt(index) ^ str.charAt(str.length()-1-index)) == 0){
                index++;
            }
            if (index != middle){
                check = false;
            }
            if (check) {
                System.out.println("Chuoi doi xung");
            } else {
                System.out.println("Chuoi khong doi xung");
            }
        }
    }
}