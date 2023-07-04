import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int nbRealPlayer;
        while(true) {
            try {
                System.out.println("Please enter number of real players: ");
                String input = scanner.nextLine();
                nbRealPlayer = Integer.parseInt(input);
                if (nbRealPlayer <=0 || nbRealPlayer > Player.MAX_PLAYERS) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("The input is not a number. Please enter again!");
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid number. The number must be 1-4");
            }
        }
        for (int i = 1; i <= nbRealPlayer; i++) {
            System.out.println("Player " + i +"'s name:");
            String name = scanner.nextLine();
            players.add(new RealPlayer(name));
        }
        if (nbRealPlayer < Player.MAX_PLAYERS) {
            for (int i = 1; i <= Player.MAX_PLAYERS - nbRealPlayer; i++) {
                players.add(new VirtualPlayer(i));
            }
        }

        Referee referee = new Referee(players);
        referee.play();
    }
}
