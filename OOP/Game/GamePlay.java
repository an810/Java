import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GamePlay {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int nbRealPlayer;
        do {
            System.out.println("Please enter number of real players: ");
            nbRealPlayer = scanner.nextInt();
            scanner.nextLine();
        } while (nbRealPlayer <=0 || nbRealPlayer > Player.MAX_PLAYERS);
        for (int i = 1; i <= nbRealPlayer; i++) {
            System.out.println("Player " + i +": ");
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
