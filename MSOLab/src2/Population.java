package src2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Population {
    public static ArrayList<Indivisual> pop = new ArrayList<>(Configs.POP_SIZE);

    public static void initPopulation() {
        for (int i = 0; i < Configs.POP_SIZE; i++) {
            Indivisual indiv = new Indivisual();
            indiv.initIndivisual();
            indiv.calcFitness();
            pop.add(indiv);
        }
    }

    public static void printPop() {
        for (Indivisual indiv : pop) {
            System.out.println("Indivisual " + String.valueOf(pop.indexOf(indiv) + 1));
            System.out.println("----------------------------------");
            System.out.println("Truck path: " + indiv.allGenTruck);
            for (Truck truck : indiv.trucks) {
                System.out.println("Number: " + String.valueOf(indiv.trucks.indexOf(truck)));
                System.out.println("Truck path: " + truck.genTruck);
                for (int i = 0; i < truck.genPackages.size(); i++) {
                    System.out.print(truck.genTruck.get(i) + ": " + truck.genPackages.get(i) + " ");
                }
                System.out.println();
                System.out.println("Graph path: " + truck.graph);
            }

            for (int i = 0; i < indiv.queueDrone.size(); i++) {
                System.out.println("Drone " + String.valueOf(i + 1));
                System.out.println("Value: " + indiv.queueDrone.get(i));
                System.out.println("Path: " + indiv.queueDroneIndex.get(i));
            }
        }
    }
}

