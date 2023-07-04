import javax.swing.*;

public abstract class Player {
    private String name;
    private int score;
    public static final int MAX_PLAYERS = 4;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void resetScore(){
        this.score = 0;
    }

    @Override
    public String toString() {
        return "Player: " + this.getName() + ", score: " + this.getScore();
    }

}
