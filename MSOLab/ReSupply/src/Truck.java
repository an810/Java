import java.util.ArrayList;
import java.util.HashMap;

public class Truck {
    public int truckIndex;
    public ArrayList<Index> route;
    public ArrayList<ArrayList<Integer>> graph;
    public HashMap<Integer, Package> CAddressToPackage;
    public int indexUpdate;
    public int availableUpdate;
    public Double timeUpdate;
    public int dimTruck;

    public Truck(int truckIndex) {
        this.truckIndex = truckIndex;
        route = new ArrayList<>();
        graph = new ArrayList<>();
        CAddressToPackage = new HashMap<>();
        indexUpdate = 0;
        availableUpdate = 0;
        timeUpdate = 0.0;
        dimTruck = -1;
    }

    public boolean isValid(int customerAddress) {
        if ((Configs.distance[0][customerAddress] / Configs.vDrone) * 2 > Configs.maxDroneTime)
            return false;
        else return true;
    }

    public void clearPackageAddress() {
        for (var r : route) {
            r.packageAddress.clear();
        }
    }
    public void initPackage() {
        clearPackageAddress();
        ArrayList<Index> validRoute = new ArrayList<>();
        for (int i = 0; i < dimTruck; i++) {
            if (isValid(route.get(i).customerAddress)) {
                validRoute.add(route.get(i));
            } else {
                route.get(0).packageAddress.add(route.get(i).customerAddress);
            }
        }
        for (int i = 0; i < validRoute.size(); i++) {
            if (i > 0) {
                double value = validRoute.get(i).valueDouble;
                for (int j = 0; j <= i; j++) {
                    if (value > (double) j / (i + 1) && value <= (double) (j + 1) / (i + 1)) {
                        for (int k = 0; k < dimTruck; k++) {
                            if (route.get(k).customerAddress == validRoute.get(j).customerAddress) {
                                route.get(k).packageAddress.add(validRoute.get(i).customerAddress);
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    public void initGraph() {
        for (int i = 0; i < dimTruck; i++) {
            int size = route.get(i).packageAddress.size();
            if (size != 0) {
                ArrayList<Integer> packageAddresses = new ArrayList<>(size);
                for (int j = 0; j < size; j++) {
                    int customerAddress = route.get(i).packageAddress.get(j);
                    int truckPickUpAddress = route.get(i).customerAddress;
                    packageAddresses.add(customerAddress);
                    CAddressToPackage.put(customerAddress, new Package(customerAddress, truckPickUpAddress, truckIndex, 0.0));
                }
                graph.add(packageAddresses);
            }
        }
    }

    public double calcTruckTime() {
        double distance = 0.0;
        int prevIndex = 0;
        int curIndex = 0;

        while (curIndex < dimTruck) {
            distance += Configs.distance[route.get(prevIndex).customerAddress][route.get(curIndex).customerAddress];
            prevIndex = curIndex;
            curIndex++;
        }
        distance += Configs.distance[route.get(prevIndex).customerAddress][0];
        double truckTime = distance / Configs.vTruck;
        return truckTime;
    }


}
