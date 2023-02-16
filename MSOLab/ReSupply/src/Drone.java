import java.util.ArrayList;

public class Drone implements Comparable<Drone>{
    public int droneNumber;
    public ArrayList<Integer> packages;
    public double timeDelivery;

    public Drone(int droneNumber) {
        this.droneNumber = droneNumber;
        packages = new ArrayList<>();
        timeDelivery = 0.0;
    }

    public int compareTo(Drone other) {
        if (this.timeDelivery > other.timeDelivery) {
            return 1;
        } else if (this.timeDelivery < other.timeDelivery) {
            return -1;
        } else {
            return 0;
        }
    }

}
