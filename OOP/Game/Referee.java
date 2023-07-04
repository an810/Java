import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Referee {
    private List<Player> players;
    private Dice dice;

    public Referee(List<Player> players) {
        this.players = players;
    }

    public void play() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int num;
            while (true) {
                try {
                    System.out.println("Choose 1 player (1-4): ");
                    num = scanner.nextInt();
                    scanner.nextLine();
                    if (num <= 0 || num > 4) {
                        throw new IllegalArgumentException();
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("The input is not a number. Please enter again!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid number. The number must be 1-4");
                }
            }
            System.out.println("Player " + players.get(num-1).getName() + "'s turn");
            Dice dice = new Dice(randomeDice());
            int result = dice.roll();
            System.out.println("Dice rolled: " + result);
            players.get(num-1).addScore(result);
            for (Player player : players) {
                System.out.println(player.toString());
            }
            if (players.get(num-1).getScore() == 21) {
                endGamePlay(players.get(num-1));
                return;
            }
            else if (players.get(num-1).getScore() > 21) {
                players.get(num-1).resetScore();
                System.out.println("Player " + players.get(num-1).getName() + "'s score is over 21, we have reset your score!");
            }
        }
    }

    private void endGamePlay(Player winner) {
        System.out.println("Player " + winner.getName() + " won!");
        for (Player player : players) {
            if (player != winner && player instanceof VirtualPlayer) {
                System.out.println(((VirtualPlayer) player).getExpression());
            }
        }
    }
    public int randomeDice() {
        Random rand = new Random();
        return rand.nextInt(4)+1;
    }
}
