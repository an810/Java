import java.lang.reflect.Array;
public class Main {
    public static void main(String[] args) {
        Input.input();
        Individual indiv = new Individual();
        indiv.initIndiv();
        for (int i = 0; i < indiv.routes.size(); i++) {
            System.out.print(indiv.routes.get(i).customerAddress + " ");
        }
        System.out.print("\n");
        for (int i = 0; i < indiv.dim; i++)
        {
            System.out.print(indiv.routes.get(i).valueDouble + " ");
        }
        System.out.println();
        for (int i = 0; i < Configs.numTrucks; i++)
        {
            for (int j = 0; j < indiv.trucks.get(i).route.size(); j++)
            {
                System.out.print(indiv.trucks.get(i).route.get(j).customerAddress + ": " + indiv.trucks.get(i).route.get(j).packageAddress + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < Configs.numTrucks; i++)
        {
            for (int j = 0; j < indiv.trucks.get(i).graph.size(); j++)
            {
                System.out.print(j + ": " + indiv.trucks.get(i).graph.get(j) + " ");
            }
            System.out.println();
        }

    }
}