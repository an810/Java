package src2;

public class Main
{
    public static void main(String[] args)
    {
        Input.input();
        Population.initPopulation();
        Population.printPop();

        for (int i = 0; i < Configs.numGeneration; i++)
        {
            Input.input();
            Population.initPopulation();
            Population.printPop();
        }
    }
}
