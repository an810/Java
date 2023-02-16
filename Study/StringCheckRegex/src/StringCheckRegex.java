import java.util.regex.Pattern;
import java.util.Scanner;
class Check {
    private final Pattern pattern;
    private static final String pattern = Pattern.compile("^[a-zA-z._-]{0,100}$");

    public Check(){
        ;
    }

    public boolean validate(final String string){
        return pattern.matcher(string).matches();
    }
}

public class StringCheckRegex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chuoi: ");
        String str = scanner.nextLine();
        Check check = new Check();
        if (check.validate(str)) {
            System.out.println("Chuoi khong co so");
        } else {
            System.out.println("Chuoi co so");
        }
    }
}
