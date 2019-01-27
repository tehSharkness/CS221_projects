/**
 * This class is used to calculate the mean of the grades.txt file,
 * and to calculate the standard of deviation.
 * 
 * @author  Sam Harkness
 * @version 1.1
 */

import java.util.Scanner;

import java.lang.Math;

import java.io.File;
import java.io.IOException;

public class Statistics
{    
    Statistics (String file)
    {
        this.file = file;        
    }
    
    public double calculateMean()
    {
        
        double sum = 0.0, mean = 0.0;
        count = 0;
        
        try
        {
            inputFile = new Scanner(new File(file));
    
            while(inputFile.hasNext())
            {
                inputFile.next();
                inputFile.next();
                sum += inputFile.nextDouble();
                count++;                
            }
        }
        catch(IOException exc)
        {
        }
                    
        mean = sum / count;
        
        return mean;
    }
    
    public double calculateStandardDeviation(double mean)
    {
        double stand = 0.0, total = 0.0;
        
        try
        {
            inputFile = new Scanner(new File(file));
    
            for(int i = 0; i < count; i++)
            {
                inputFile.next();
                inputFile.next();
                
                total += Math.pow(inputFile.nextDouble() - mean, 2);
            }
        }
        catch(IOException exc)
        {
        }
        
        stand = Math.sqrt(total / count);
        
        return stand;            
    }
    
    private String file;
    private Scanner inputFile;
    private int count;
}
