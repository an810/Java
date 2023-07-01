import java.util.Random;

public class VirtualPlayer extends Player{
    private String expression;

    public VirtualPlayer(int num) {
        super("Virtual player " + num);
        randomExpression();
    }
    public String getExpression() {
        return this.getName() + ": " + expression;
    }
    public void randomExpression() {
        Random rand = new Random();
        int randVal = rand.nextInt(100) + 1;
        if (randVal <= 25) this.expression = "Looks like luck is not on my side today.";
        else if (randVal <= 50) this.expression = "Well played, everyone. I'll have to step up my game.";
        else if (randVal <= 75) this.expression = "Seems like I'm the underdog in this game.";
        else this.expression = "Another loss for me. I'll get better next time!";
    }

}
