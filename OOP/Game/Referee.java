import java.util.List;
import java.util.Random;

public class Referee {
    private List<Player> players;
    private Dice dice;

    public Referee(List<Player> players) {
        this.players = players;
    }

    public void play() {
        while (true) {
            for (Player player : players) {
                System.out.println("Player " + player.getName() + "'s turn");
                Dice dice = new Dice(randomeDice());
                int result = dice.roll();
                System.out.println("Dice rolled: " + result);
                player.addScore(result);
                if (player.getScore() == 21) {
                    endGamePlay(player);
                    return;
                }
                else if (player.getScore() > 21) {
                    player.resetScore();
                    System.out.println("Player " + player.getName() + "'s score is over 21, we have reset your score!");
                }
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
