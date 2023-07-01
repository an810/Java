import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {
    private Random random;
    private int value;
    public Dice(int value){
        this.random = new Random();
        this.value = value;
    }

    public int roll(){
        int randVal = random.nextInt(100) + 1;
        if (randVal <= 16) return 1;
        else if (randVal <= 32) return 2;
        else if (randVal <= 48) return 3;
        else if (randVal <= 64) return 4;
        else if (randVal <= 80) return 5;
        else if (randVal <= 96) return 6;
        else return value;
    }
}
