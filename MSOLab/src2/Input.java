package src2;

import java.util.Scanner;
import java.lang.Math;

public class Input
{
    public static void input()
    {
        Scanner in = new Scanner(System.in);
        do
        {
            System.out.print("Enter number of Trucks: ");
            Configs.numTrucks = in.nextInt();
        } while (Configs.numTrucks < 1);
        do
        {
            System.out.print("Enter number of Drones: ");
            Configs.numDrones = in.nextInt();
        } while (Configs.numDrones < 1);
        System.out.print("Enter dimension: ");
        int dim = in.nextInt();
        in.nextLine();

        Configs.xCor = new double[dim];
        Configs.yCor = new double[dim];
        Configs.releaseDates = new double[dim];
        Configs.matrix = new double[dim][dim];
        Configs.numCustomers = dim - 1;
        for (int i = 0; i < dim; i++)
        {
            String line = in.nextLine();
            String[] doubles = line.split(" ");
            Configs.xCor[i] = Double.parseDouble(doubles[0]);
            Configs.yCor[i] = Double.parseDouble(doubles[1]);
            Configs.releaseDates[i] = Double.parseDouble(doubles[2]);
        }
        for (int i = 0; i < dim; i++)
        {
            for (int j = 0; j < dim; j++)
            {
                if (i == j)
                {
                    Configs.matrix[i][j] = 0.0;
                }
                else
                {
                    Configs.matrix[i][j] = Math.sqrt(Math.pow(Configs.xCor[j] - Configs.xCor[i], 2) + Math.pow(Configs.yCor[j] - Configs.yCor[i], 2));
                }
            }
        }
    }
}
