import java.util.Comparator;

public class Package implements Comparable<Package>{
    public int customerAddress;
    public int truckPickUpAddress;
    public int belongToTruck;
    public double timeReady;

    public Package(int customerAddress, int truckPickUpAddress, int belongToTruck, double timeReady) {
        this.customerAddress = customerAddress;
        this.truckPickUpAddress = truckPickUpAddress;
        this.belongToTruck = belongToTruck;
        this.timeReady = timeReady;
    }

    public int compareTo(Package other) {
        if (this.timeReady > other.timeReady) {
            return 1;
        } else if (this.timeReady < other.timeReady) {
            return -1;
        } else {
            return 0;
        }
    }

}
