package src2;

import java.util.ArrayList;
public class Truck
{
    public ArrayList<Integer> genTruck;
    public ArrayList<Double> genDouble;
    public ArrayList<ArrayList<Integer>> genPackages;
    public ArrayList<ArrayList<Integer>> graph;
    public ArrayList<Integer> indexes;
    public ArrayList<ArrayList<Double>> timeFinish;
    public ArrayList<Double> timeUpdate;
    public int dim;

    public Truck()
    {
        genTruck = new ArrayList<>();
        genDouble = new ArrayList<>();
        genPackages = new ArrayList<>();
        graph = new ArrayList<>();
        indexes = new ArrayList<>();
        timeFinish = new ArrayList<>();
        timeUpdate = new ArrayList<>();
        dim = -1;
    }

    public void initGenPackages()
    {
        for (int i = 0; i < dim; i++)
        {
            double value = genDouble.get(i);
            if (i > 0)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (value > (double) j / (i + 1) && value <= (double) (j + 1) / (i + 1))
                    {
                        genPackages.get(j).add(genTruck.get(i));
                    }
                }
            }
        }
    }

    public void initGraph()
    {
        for (int i = 0; i < dim; i++)
        {
            int size = genPackages.get(i).size();
            if (size != 0)
            {
                graph.add(genPackages.get(i));
                indexes.add(genTruck.get(i));
                timeFinish.add(new ArrayList<>(size));
                timeUpdate.add(0.0);
            }
        }
    }

    public void initUpdateTime(int index)
    {
        double max = 0.0;
        int size = timeFinish.get(index).size();

        for (int i = 0; i < size; i++)
        {
            double value = timeFinish.get(index).get(i);

            if (max < value)
            {
                max = value;
            }
        }

        timeUpdate.set(index, max);
    }
}
