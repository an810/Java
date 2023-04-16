import java.util.Scanner;

public class DaysOfMonth {
    public static void main(String[] args) {
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        Scanner sc = new Scanner(System.in);
        boolean checkMonth = true, checkYear = true;
        int month = 0, year = 0, day = 0;
        while (checkMonth) {
            System.out.print("Please enter month: ");
            String iMonth = sc.nextLine();
            if (!check(iMonth)) {
                System.out.println("Invalid!");
            } else {
                if (iMonth.length() != 1) {
                    for (int i=1; i<=12; i++) {
                        if (iMonth.substring(0,3).equals(months[i].substring(0,3))) {
                            month = i;
                        }
                    }
                }
                else month = Integer.parseInt(iMonth);
                checkMonth = false;
            }
        }
        while (checkYear) {
            System.out.print("Please enter non-negative year: ");
            year = sc.nextInt();
            if (year <= 0) {
                System.out.println("Invalid!");
            } else {
                checkYear = false;
            }
        }

        switch (month) {
            case 2:
                if ((year % 4 == 0 && year % 100 !=0) || year % 400 == 0)  {
                    System.out.println("Number of days: 29");
                } else System.out.println("Number of days: 28");
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Number of days: 31");
                break;
            default:
                System.out.println("Number of days: 30");
                break;
        }


    }

    private static boolean check(String month) {
        String[] months = {"","Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 1; i <= 12; i++) {
            if (!(month.equals(months[i])) || !(month.equals(months[i] + ".")) || !(month.equals(""))) {
                return false;
            }
        }

        return true;
    }




}
