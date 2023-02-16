import javax.lang.model.element.PackageElement;
import java.util.*;


public class Individual  {
    public int dim;
    public double fitness;
    public ArrayList<Index> routes;
    public ArrayList<Truck> trucks;
    public PriorityQueue<Drone> drones;
    public PriorityQueue<Package> packages;




    public Individual() {
        dim = Configs.numCustomers + Configs.numTrucks;
        routes = new ArrayList<>();
        trucks = new ArrayList<>();
        packages = new PriorityQueue<>();
        drones = new PriorityQueue<>();
        fitness = 0.0;
    }

    public void initIndiv() {
        for (int i = 1; i <= Configs.numCustomers; i++) {
            Index tempIndiv= new Index(i, Configs.randDouble());
            routes.add(tempIndiv);
        }
        for (int i = 1; i <= Configs.numTrucks; i++) {
            Index tempIndiv= new Index(0, 0.0);
            routes.add(tempIndiv);
        }
        Collections.shuffle(routes);
        routes.add(0, new Index(0, 0.0));
        initTruck();
    }

    public void initTruck() {
        int index = 0;
        for (int i = 0; i < Configs.numTrucks; i++) {
            Truck newTruck = new Truck(i);
            int dimTruck = 0;
            do {
                newTruck.route.add(routes.get(index));
                dimTruck++;
                index++;
            } while (index < dim && routes.get(index).customerAddress != 0);
            newTruck.dimTruck = dimTruck;
            newTruck.initPackage();
            newTruck.initGraph();
            trucks.add(newTruck);
        }
    }

    public void calcFitness() {
        for (int i = 0; i < Configs.numDrones; i++) {
            drones.add(new Drone(i + 1));
        }

        while (true) {
            int count = 0;

            for (Truck truck : trucks) {
                if (truck.indexUpdate < truck.graph.size()) {
                    break;
                }
                count++;
            }

            if (count == Configs.numTrucks && packages.size() == 0) {
                break;
            }

            for (Truck truck : trucks) {
                int index = truck.indexUpdate;
                int availableIndex = truck.availableUpdate;
                if (truck.graph.size() == 0 || index == truck.graph.size() || index < availableIndex) {
                    continue;
                }
                int size = truck.graph.get(index).size();
                double time = 0.0;
                truck.availableUpdate++;

                if (index > 0) {
                    int index1 = truck.CAddressToPackage.get(truck.graph.get(index - 1).get(0)).truckPickUpAddress;
                    int index2 = truck.CAddressToPackage.get(truck.graph.get(index).get(0)).truckPickUpAddress;
                    double distance = Configs.distance[index1][index2];
                    time = distance / Configs.vTruck - distance / Configs.vDrone + truck.timeUpdate;
                }
                for (int i = 0; i < size; i++) {
                    int customerAddress = truck.graph.get(index).get(i);
                    truck.CAddressToPackage.get(customerAddress).timeReady = Math.max(Configs.releaseDates[customerAddress], time);
                    packages.add(truck.CAddressToPackage.get(customerAddress));
                }
            }

            assignDrone(0, Configs.randInt(1,Configs.droneCapacity + 1), drones.peek().timeDelivery);

            for (Truck truck : trucks) {
                int index = truck.indexUpdate;
                if (truck.graph.size() == 0 || index == truck.graph.size()) {
                    continue;
                }
                int size = truck.graph.get(index).size();

                int i = 0;
                double max = 0.0;

                while (i < size) {
                    int customerAddress = truck.graph.get(index).get(i);
                    double time = truck.CAddressToPackage.get(customerAddress).timeReady;

                    if (truck.CAddressToPackage.get(customerAddress).timeReady == 0.0) {
                        break;
                    }
                    if (max < time) {
                        max = time;
                    }
                    i++;
                }

                if (i == size) {
                    truck.indexUpdate++;
                    truck.timeUpdate = max;
                }
            }
        }

        double totalTime = 0.0;
        for (Drone drone : drones) {
            totalTime += drone.timeDelivery;
        }
        for (Truck truck : trucks) {
            totalTime += truck.calcTruckTime();
        }
        fitness = 1 / totalTime;

    }

    private void assignDrone(int currentPackageOnADrone, int numberOfDeliveryPackages, double t) {
        PriorityQueue<Package> tmp = new PriorityQueue<>();

        while (packages.size() > 0 && currentPackageOnADrone < numberOfDeliveryPackages) {
            Package tmpPackage = packages.poll();
            tmp.add(tmpPackage);
            double r = tmpPackage.timeReady;
            if (t < r) {
                t = r;
            }
            currentPackageOnADrone++;
        }
        updateTimeReadyAndDrone(tmp, t);
    }

    private void updateTimeReadyAndDrone(PriorityQueue<Package> tmp, double t) {
        int prevTruckPickUpAddress = 0;
        double droneValue = t;
        double startDroneValue = t;
        Drone aDrone = drones.poll();

        while (tmp.size() > 0) {
            Package tmpPackage = tmp.poll();
            int customerAddress = tmpPackage.customerAddress;
            int truckPickUpAddress = tmpPackage.truckPickUpAddress;
            double time = Configs.distance[prevTruckPickUpAddress][truckPickUpAddress];

            aDrone.packages.add(customerAddress);
            t += time;
            droneValue = droneValue + t - startDroneValue;
            trucks.get(tmpPackage.belongToTruck).CAddressToPackage.get(customerAddress).timeReady = t;
            prevTruckPickUpAddress = truckPickUpAddress;
        }
        aDrone.timeDelivery += droneValue;
        drones.add(aDrone);
    }

    public static ArrayList<Individual> crossover(Individual p1, Individual p2) {
        ArrayList<Individual> children = new ArrayList<>();



        return children;
    }

}


