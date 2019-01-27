
public class Lab5
{
    public static void main (String [] args)
    {
        String fileName = "grades.txt";
        Statistics stats = new Statistics(fileName);
        double mean;
        double standardDeviation;
        
        System.out.println("CS 221, In Lab 5");
        System.out.println("----------------");
        
        mean = stats.calculateMean();
        System.out.println("Mean: " + mean);
        
        standardDeviation = stats.calculateStandardDeviation(mean);
        System.out.println("Standard Deviation: " + standardDeviation);
    }

}
