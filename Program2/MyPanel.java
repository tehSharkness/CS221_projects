/**
 * The panel upon which the MyButtons are placed in the 8X8 or 10X10 grid.
 * 
 * @author  Samuel Harkness
 * @version 1.0
 */
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import java.util.Random;

import java.lang.Math;

import java.awt.event.ActionListener;

public class MyPanel extends JPanel
{
    public static int size = 0;//the number of columns and rows
    
    private final int grid;//the square of size
    
    private Random random;//used for random numbers and booleans
        
    private int i, j, k;//used in numerous for loops to initialized the other variables     
        
    private static int[][] position;//the total number of buttons, used to determine where the ships are located
    
    /**
     * The default constructor for MyPanel.
     */
    public MyPanel(MyFrame p)
    {
        grid = (int)Math.pow(size, 2);
                             
        MyButton[][] buttons = new MyButton[size][size];
        
        position = new int[size][size];
        
        random = new Random();
        
        setPreferredSize(new Dimension(800, 800));
        setLayout(new GridLayout(size, size));
        
        Color[] color = {Color.black, Color.green, Color.blue, Color.red, Color.yellow};
        
        do
        {
            removeAll();//resets the panel
            
            for(i = 0; i < size; i++)
            {
                for(j = 0; j < size; j++)
                {                    
                    position[i][j] = 1;//sets the panel to have all miss buttons
                }
            }
            
            for(i = 2; i < 6; i++)
            {
                populateBoard(i);
            }
             
            for(i = 0; i < size; i++)
            {
                for(j = 0; j < size; j++)
                {
                    for(k = 1; k < 6; k++)
                    {
                        if(k == position[i][j])
                        {
                            buttons[i][j] = new MyButton(color[k - 1], p);
                        }
                    }
                    add(buttons[i][j]);
                }
            }
        }while(getComponentCount() != grid);//if the ships overlap, the program restarts
    }
    
    /**
     * Determines the pseudorandom placement of the ships on the 8X8 grid.
     * 
     * @param   length  The length of the ship, measured in buttons.
     * @param   z       The limiting number that prevents the ships from overflowing into the next row.
     * @param   orient  The orientation of the ship.  Vertical or Horizontal.
     * @return          The position of the buttons of the ship on the 8X8 grid.
     */
    public static void populateBoard(int length)
    {
        Random random = new Random();//used to randomly place the ships
        
        boolean cont = false;//used to tell the loop whether to keep trying to place the ship or not
        
        boolean orientation = false;//used to designate whether the ship should go vertical or horizontal
        
        int x;//the x value of the ship position
        
        int y;//the y value of the ship position
        
        boolean emptySquare = true;//checks if the specific square is empty or not
        
        while (!cont)
        {    
            emptySquare = true;        
        
            orientation = random.nextBoolean();
        
            x = random.nextInt(size);
            y = random.nextInt(size);            
       
            //vertical
            if (orientation)
            {  
                if (y + length <= size)
                {                  
                    for (int i = y; i < y + length; i++)
                    {
                        //square is already occupied
                        if (position[x][i] != 1)
                        {
                            emptySquare = false;
                        }
                    }  
                
                    //ship can be placed here
                    if (emptySquare)
                    {
                        for (int i = y; i < y + length; i++)
                        {
                            position[x][i] = length;
                        }                           
                        return;
                    }
                }          
            }            
        
            //horizontal
            if (!orientation)
            {
                if (x - length >= 0)
                {                                                    
                    for (int i = x; i > x - length; i--)
                    {
                        //square is already occupied
                        if (position[i][y] != 1)
                        {
                            emptySquare = false;
                        }                        
                    }
                    
                    //ship can be placed here
                    if (emptySquare)
                    {
                        for (int i = x; i > x - length; i--)
                        {
                            position[i][y] = length;                                                      
                        }
                        return;
                    }
                }               
            }
        }           
    }
}