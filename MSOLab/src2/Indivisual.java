package src2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.lang.Math;

public class Indivisual
{
    public ArrayList<Integer> allGenTruck;
    public ArrayList<Double> allGenDouble;
    public ArrayList<Truck> trucks;
    public LinkedList<Integer> queueNum;
    public LinkedList<Double> queuePack;
    public LinkedList<Double> queueDrone;
    public LinkedList<LinkedList<Integer>> queueDroneIndex;
    int dim;
    double fitness;

    public Indivisual()
    {
        dim = Configs.numCustomers + Configs.numTrucks;
        allGenTruck = new ArrayList<>(dim);
        allGenDouble = new ArrayList<>(dim);
        trucks = new ArrayList<>();
        queueNum = new LinkedList<>();
        queuePack = new LinkedList<>();
        queueDrone = new LinkedList<>();
        queueDroneIndex = new LinkedList<>();
        fitness = 0.0;
    }

    public void initIndivisual()
    {
        for (int i = 1; i <= Configs.numCustomers; i++)
        {
            allGenTruck.add(i);
            allGenDouble.add(Configs.randDouble());
        }
        for (int i = 0; i < Configs.numTrucks - 1; i++)
        {
            allGenTruck.add(0);
            allGenDouble.add(Configs.randDouble());
        }
        Collections.shuffle(allGenTruck);
        allGenTruck.add(0, 0);
        allGenDouble.add(0, Configs.randDouble());
        initTrucks();
        initQueue();
    }

    private void initTrucks()
    {
        int index = 0;
        for (int i = 0; i < Configs.numTrucks; i++)
        {
            Truck newTruck = new Truck();
            int truckDim = 0;
            do
            {
                newTruck.genTruck.add(allGenTruck.get(index));
                newTruck.genDouble.add(allGenDouble.get(index));
                newTruck.genPackages.add(new ArrayList<>());
                truckDim++;
                index++;
            } while (index < dim && allGenTruck.get(index) != 0);
            newTruck.dim = truckDim;
            newTruck.initGenPackages();
            newTruck.initGraph();
            trucks.add(newTruck);
        }
    }

    private void initQueue()
    {
        for (int i = 0; i < Configs.numDrones; i++)
        {
            queueDrone.addLast(0.0);
            queueDroneIndex.addLast(new LinkedList<>());
        }

        int index = 0;
        while (true)
        {
            boolean end = true;
            for (Truck truck : trucks)
            {
                if (index < truck.graph.size())
                {
                    int size = truck.graph.get(index).size();
                    double time = 0.0;
                    int timeUpdateIndex = 0;

                    if (index > 0)
                    {
                        double distance = Configs.matrix[truck.indexes.get(index - 1)][truck.indexes.get(index)];
                        time = distance / Configs.vTruck - distance / Configs.vDrone;
                        timeUpdateIndex = index - 1;
                    }
                    for (int i = 0; i < size; i++)
                    {
                        queueNum.addLast(truck.graph.get(index).get(i));
                        queuePack.addLast(Math.max(Configs.releaseDates[truck.graph.get(index).get(i)], truck.timeUpdate.get(timeUpdateIndex) + time));
                    }
                    end = false;
                }
            }
            if (end)
            {
                break;
            }

            cycleN(index, 0, Configs.randInt(1, Configs.droneCapacity + 1), queueDrone.getFirst());
            for (Truck truck : trucks)
            {
                if (index < truck.graph.size())
                {
                    truck.initUpdateTime(index);
                }
            }
            index++;
        }
    }

    private void cycleN(int index, int i, int numDeliveryPackages, double t)
    {
        ArrayList<Integer> nums = new ArrayList<>();

        while (queuePack.size() > 0 && i < numDeliveryPackages)
        {
            double r = queuePack.getFirst();
            queuePack.removeFirst();
            nums.add(queueNum.getFirst());
            queueNum.removeFirst();

            if (t < r)
            {
                t = r;
            }
            i++;
        }

        double valueDrone = t;
        for (int j = 0; j < nums.size(); j++)
        {
            valueDrone += updateTimeFinish(index, nums.get(j), j + 1, t);
            queueDroneIndex.getFirst().add(nums.get(j));
        }
        queueDroneIndex.addLast(queueDroneIndex.getFirst());
        queueDroneIndex.removeFirst();
        queueDrone.addLast(queueDrone.getFirst() + valueDrone);
        queueDrone.removeFirst();

        if (queuePack.size() > 0)
        {
            cycleN(index, 0, Configs.randInt(1, Configs.droneCapacity + 1), t);
        }
    }

    private double updateTimeFinish(int index, int where, int scale, double t)
    {
        double theTime = 0.0;

        for (Truck truck : trucks)
        {
            if (index < truck.graph.size())
            {
                for (int i = 0; i < truck.graph.get(index).size(); i++)
                {
                    if (where == truck.graph.get(index).get(i))
                    {
                        double time = 0.0;
                        if (index != 0)
                        {
                            double distance = Configs.matrix[truck.indexes.get(index - 1)][truck.indexes.get(index)];
                            time = distance / Configs.vDrone;
                        }
                        theTime = scale * time;
                        truck.timeFinish.get(index).add(t + theTime);
                        return theTime;
                    }
                }
            }
        }

        return 0.0;
    }

    public void calcFitness()
    {
        double value = 0.0;

        for (Truck truck : trucks)
        {
            for (int i = 1; i < truck.genTruck.size(); i++)
            {
                value += Configs.matrix[truck.genTruck.get(i - 1)][truck.genTruck.get(i)];
            }
        }

        value /= Configs.vTruck;

        for (int i = 0; i < queueDrone.size(); i++)
        {
            value += queueDrone.get(i);
        }

        fitness = 1 / value;
    }
}
