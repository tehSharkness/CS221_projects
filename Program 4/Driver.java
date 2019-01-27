import java.util.Scanner;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * The driver class to test out the applicant selection process.
 * 
 * @author  Sam Harkness
 * @version 1.0
 */
public class Driver
{
    public static void main (String [] args)
    {
        Scanner in = new Scanner(System.in);
        int N, k, m;
        Node checkM, checkK;
        boolean bool = true;
        
        PrintWriter outputFile;
        
        while(bool)
        {
            try
            {            
                outputFile = new PrintWriter(new FileWriter("program4.txt"));
                
                System.out.print("Filename: ");
                Scanner inputFile = new Scanner(new File(in.next()));
                
                bool = false;
                System.out.println();
                in.close();
                
                outputFile.println("Program 4");
                outputFile.println("---------");
                
                while(inputFile.hasNext())
                {
                    N = inputFile.nextInt();
                    k = inputFile.nextInt();
                    m = inputFile.nextInt();
                    
                    if(N == 0 && k == 0 && m == 0)
                    {
                        break;
                    }
                               
                    outputFile.println();
                    outputFile.println("N = " + N + ", k = " + k + ", m = " + m);
                    outputFile.println();
                    outputFile.println("Output");
                    outputFile.println("------");
                    
                    LinkedList<Node> applicants = new LinkedList<Node>(N);
                    
                    checkM = applicants.first.getNext();
                    checkK = applicants.first.getPrevious();
                    
                    while(N > 0)
                    {
                        while(m > N)
                        {
                            m = m - N;
                        }
                        while(k > N)
                        {
                            k = k - N;
                        }
                        
                        if(checkM.getIndex() == 0)
                        {
                            checkM = checkM.getPrevious();
                        }
                        if(checkK.getIndex() == 0)
                        {
                            checkK = checkK.getNext();
                        }
                        
                        for(int i = 0; i < m; i++)
                        {
                            checkM = checkM.getPrevious();
                            
                            if(checkM.getIndex() == 0)
                            {
                                checkM = checkM.getPrevious();
                            }
                        }                        
                        for(int i = 0; i < k; i++)
                        {
                            checkK = checkK.getNext();
                            
                            if(checkK.getIndex() == 0)
                            {
                                checkK = checkK.getNext();
                            }
                        }              
                        
                        if(checkK.getIndex() == checkM.getIndex())
                        {
                            applicants.remove(checkK.getIndex());
                            outputFile.println(checkK.getIndex());
                            
                            N = N - 1;
                        }
                        else
                        {
                            applicants.remove(checkK.getIndex());
                            outputFile.print(checkK.getIndex() + " ");
                            
                            applicants.remove(checkM.getIndex());
                            outputFile.print(checkM.getIndex());
                            
                            N = N - 2;
                            
                            outputFile.println();
                        }   
                        
                        if(checkM.getIndex() == checkK.getNext().getIndex())
                        {
                            checkK = checkK.getNext();
                        }
                    }
                }
                
                outputFile.println();
                outputFile.print("End of Program 4");
                outputFile.close();
                
                in = new Scanner(new File("program4.txt"));
                
                while(in.hasNext())
                {
                    System.out.println(in.nextLine());
                }
            }
            catch(FileNotFoundException exc)
            {
                System.out.println("\nThat is not a valid file.  Please try again.\n");
            }
            catch(IOException exc)
            {
            }
        }
    }
}
