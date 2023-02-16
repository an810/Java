import java.util.Random;
public class Configs
{
    public static int numTrucks;
    public static int numDrones;
    public static int numCustomers;

    public static double vTruck = 1.0;
    public static double vDrone = 1.33;
    public static int droneCapacity = 3;
    public static double[] xCor;
    public static double[] yCor;
    public static double[] releaseDates;
    public static double[][] distance;
    public static final int POP_SIZE = 10;
    public static final int numGeneration = 100;
    public static final double maxDroneTime = 50.0;
    public static int randInt(int lowerBound, int upperBound)
    {
        Random rand = new Random();

        int r = rand.nextInt(upperBound - lowerBound) + lowerBound;

        return r;
    }

    public static double randDouble()
    {
        Random rand = new Random();
        double r = rand.nextDouble();
        return r;
    }
}
