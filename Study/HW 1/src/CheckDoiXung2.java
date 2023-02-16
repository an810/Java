import java.util.Scanner;
public class CheckDoiXung2 {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String str = scanner.nextLine();
        if (str.length() % 2 != 0) {
            System.out.println("Chuoi khong the sap xep thanh 1 chuoi doi xung");
        } else {
            int check = 0;
            for (int i =0; i<str.length(); i++ ){
                int temp = str.charAt(i) - 'a' + 1;
                check ^= temp;
            }
            if (check != 0) {
                System.out.println("Chuoi khong the sap xep thanh 1 chuoi doi xung");
            } else {
                System.out.println("Chuoi co the sap xep thanh 1 chuoi doi xung");
            }
        }
    }
}
