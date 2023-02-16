import java.util.ArrayList;

public class Index {
    public int customerAddress;
    public double valueDouble;
    public ArrayList<Integer> packageAddress;
    public Index(int customerAddress, double valueDouble) {
        this.customerAddress = customerAddress;
        this.valueDouble = valueDouble;
        packageAddress = new ArrayList<>();
    }
}
