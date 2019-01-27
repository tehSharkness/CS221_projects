/**
 * Examines an html file and outputs the names of the tags contained within, and the number of times that each tag occurs.
 * 
 * @author Sam Harkness
 * @version 3/2/06
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

import java.io.File;
import java.io.FileNotFoundException;

import java.lang.Character;

public class Driver
{
    private static ArrayList<String> strings;//used to store all the names of the tags, due to an error with tags
    private static String[] list;//used for sorting the tags
    private static ArrayList<Tag> tags;//stores both the tags and the number of times that each tag occurs
    private static String str;//the name of the file
    
    /**
     * The main method for the program.
     */
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        String temp = null;
        
        str = null;
        
        boolean bool = true;
        
        while(bool)
        {
            System.out.print("Please enter the name of a file: ");
            str = in.next();
            
            try
            {
                temp = change(str);
                bool = false;
            }
            catch(FileNotFoundException exc)
            {
                System.out.println("That file does not exist.");
            }
        }      
        
        String use = " ";
        
        use = tags(temp);
        
        Scanner read = new Scanner(use);
        strings = new ArrayList<String>();
        
        strings.add(read.next());        
    
        try
        {            
            tagReader(read, temp);
        }
        catch(NoSuchElementException exc)
        {
        }
        
        Arrays.sort(list);
        
        int[] num = new int[strings.size()];
        
        for(int i = 0; i < num.length; i++)
        {
            num[i] = 0;
        }
        
        try
        {            
            for(int i = 0; i < list.length; i++)
            {
                read = new Scanner(use);
                
                while(read.hasNext())
                {
                    if(read.next().equals(list[i]))
                    {
                        num[i]++;
                    }
                }
            }        
        }
        catch(NoSuchElementException exc)
        {}
        
        tags = new ArrayList<Tag>();
        
        print(num);
    }
    
    /**
     * Creates a string representation of the file, easier to handle than the file.
     * 
     * @param   str   The name of the file to be examined.
     * @return        The string representation of the file.
     * @throws  FileNotFoundException   If the file specified by str is not available.
     */
    public static String change(String str) throws FileNotFoundException
    {
        Scanner input = new Scanner(new File(str));
            
        input.useDelimiter("/d");
      
        String temp = input.next().toLowerCase();
          
        try
        {
            while(input.hasNext())
            {
                temp += input.next().toLowerCase();
            }
        }
        catch(NoSuchElementException exc)
        {}
        
        return temp;
    }
    
    /**
     * Creates a new string containing only the tags.
     * 
     * @param   temp    The representation of the file.
     * @return          The string containing only the tags.
     */
    public static String tags(String temp)
    {
        int i = 0;
        Character c;
        String s;
        String use = " ";
      
        while(i < temp.length())
        {
            while(i < temp.length())
            {
                c = temp.charAt(i);
                s = c.toString();
                if(s.equals("<"))
                {
                    break;
                }
                i++;
            }
            
            i++;
            
            while(i < temp.length())
            {
                c = temp.charAt(i);
                s = c.toString();
                
                if(s.equals(">") || s.equals("/") || s.equals("!") || s.equals(" "))
                {
                    use += " ";
                    break;
                }
                
                use += s;
                i++;                   
            }
        }
        
        return use;
    }
    
    /**
     * Forms an array of all the tags without a repetition of tags.
     * 
     * @param   read    Examines the string containing only tags.
     * @param   temp    Contains only tags.
     * @throws  NoSuchElementException   If the loop passes outside the range of an array.
     */
    public static void tagReader(Scanner read, String temp) throws NoSuchElementException
    {
        while(read.hasNext())
        {
            temp = read.next();
            boolean bool = false;
            
            for(int i = 0; i < strings.size(); i++)
            {                    
                if(strings.get(i).equals(temp))
                {
                    bool = true;
                    break;
                }
            }
            
            if(bool)
            {
                continue;
            }
            
            strings.add(temp);
        }
        
        list = new String[strings.size()];
        
        for(int i = 0; i < strings.size(); i++)
        {
            list[i] = strings.get(i);
        }
    }
    
    /**
     * Prints out the tags and the number of times they appear.
     * 
     * @param   num    The number of times that a tag appears.
     */
    public static void print(int[] num)
    {
        System.out.println("\nHTML tag analysis for " + str + "\n");        
        System.out.println("tag\t\t\tcount");
        System.out.println("---\t\t\t-----");
        
        for(int i = 0; i < strings.size(); i++)
        {
            tags.add(new Tag(list[i], num[i]));
            
            System.out.print(tags.get(i).getName());
            
            boolean bool = true;
            
            int j = 10, l = 0;           
            
            while(bool)//is supposed to format the tags and their counts
            {
                if(tags.get(i).getCount() < j);
                {
                    for(int k = tags.get(i).getName().length(); k < (28 - l); k++)
                    {
                        System.out.print(" ");
                        bool = false;
                    }
                }
                
                j *= 10;
                l++;
            }
            
            System.out.println(tags.get(i).getCount());
        }
    }
}
