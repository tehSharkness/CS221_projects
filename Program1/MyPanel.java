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
    
    /**
     * The default constructor for MyPanel.
     */
    public MyPanel(MyFrame p)
    {
        grid = (int)Math.pow(size, 2);
        
        int[] mine;//the position of the buttons of the minsweeper
        int[] frig;//the position of the buttons of the frigate
        int[] cruis;//the position of the buttons of the cruiser
        int[] battl;//the position of the buttons of the battleship
        int[] position;//the total number of buttons, used to determine where the ships are located
                             
        MyButton[] buttons;
        
        MyButton[] misses;
        
        random = new Random();
        mine = new int[2];
        frig = new int[3];
        cruis = new int[4];
        battl = new int[5];
        position = new int[grid];
        buttons = new MyButton[14];
        misses = new MyButton[grid - 14];
        
        for(i = 0; i < misses.length; i++)
        {
            misses[i] = new MyButton(Color.black, p);
        }
        
        setPreferredSize(new Dimension(800, 800));
        setLayout(new GridLayout(size, size));
        
        do
        {
            removeAll();//resets the panel
            
            for(i = 0; i < grid; i++)
            {
                position[i] = 0;//sets the panel to have all miss buttons
            }
            
            for(i = 0; i < 2; i++)
            {
                mine[i] = 0;
                buttons[i] = new MyButton(Color.green, p);
            }
            
            for(i = 0; i < 3; i++)
            {
                frig[i] = 0;
                buttons[i + 2] = new MyButton(Color.blue, p);
            }
            
            for(i = 0; i < 4; i++)
            {
                cruis[i] = 0;
                buttons[i + 5] = new MyButton(Color.red, p);
            }
            
            for(i = 0; i < 5; i++)
            {
                battl[i] = 0;
                buttons[i + 9] = new MyButton(Color.yellow, p);
            }
            
            mine = setPosition(mine.length, size - 1);//determines where the ships are located
            frig = setPosition(frig.length, size - 2);
            cruis = setPosition(cruis.length, size - 3);
            battl = setPosition(battl.length, size - 4);
            
            for(i = 0; i < 2; i++)
            {
                position[ mine[i] ] = 1;//sets the position to have hit buttons at the locations of the ships
            }
            for(i = 0; i < 3; i++)
            {
                position[ frig[i] ] = 1;
            }
            for(i = 0; i < 4; i++)
            {
                position[ cruis[i] ] = 1;
            }
            for(i = 0; i < 5; i++)
            {
                position[ battl[i] ] = 1;
            }
            
            for(i = 0; i < grid; i++)
            {
                if(position[i] == 1)
                {
                    for(j = 0; j < 2; j++)
                    {
                        if(mine[j] == i)
                        {
                            add(buttons[j]);
                        }
                    }
                    
                    for(j = 0; j < 3; j++)
                    {
                        if(frig[j] == i)
                        {
                            add(buttons[j + 2]);
                        }
                    }
                    
                    for(j = 0; j < 4; j++)
                    {
                        if(cruis[j] == i)
                        {
                            add(buttons[j + 5]);
                        }
                    }
                    
                    for(j = 0; j < 5; j++)
                    {
                        if(battl[j] == i)
                        {
                            add(buttons[j + 9]);
                        }
                    }
                }
                else if(position[i] == 0)
                {
                    add(new MyButton(Color.black, p));
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
    public int[] setPosition(int length, int z)
    {
        int[] r = new int[length];
        boolean orient = random.nextBoolean();//randomly determines the orientation
        if(orient)//the ship is horizontal
        {            
            switch(1 + random.nextInt(size))//randomly determines which row the ship will be located in
            {
                case 1:{r[0] = random.nextInt(z);}break;
                case 2:{r[0] = size + random.nextInt(z);}break;
                case 3:{r[0] = 2 * size + random.nextInt(z);}break;
                case 4:{r[0] = 3 * size + random.nextInt(z);}break;
                case 5:{r[0] = 4 * size + random.nextInt(z);}break;
                case 6:{r[0] = 5 * size + random.nextInt(z);}break;
                case 7:{r[0] = 6 * size + random.nextInt(z);}break;
                case 8:{r[0] = 7 * size + random.nextInt(z);}break;
                case 9:{r[0] = 8 * size + random.nextInt(z);}break;
                case 10:{r[0] = 9 * size + random.nextInt(z);}break;
                default: break;
            }
            
            for(k = 1; k < length; k++)
            {
                r[k] = r[k-1] + 1;
            }
        }
        else//the ship is horizontal
        {
            switch(1 + random.nextInt(size))//randomly determines which column the ship is in
            {
                case 1:{r[0] = size * random.nextInt(z);}break;
                case 2:{r[0] = 1 + size * random.nextInt(z);}break;
                case 3:{r[0] = 2 + size * random.nextInt(z);}break;
                case 4:{r[0] = 3 + size * random.nextInt(z);}break;
                case 5:{r[0] = 4 + size * random.nextInt(z);}break;
                case 6:{r[0] = 5 + size * random.nextInt(z);}break;
                case 7:{r[0] = 6 + size * random.nextInt(z);}break;
                case 8:{r[0] = 7 + size * random.nextInt(z);}break;
                case 9:{r[0] = 8 + size * random.nextInt(z);}break;
                case 10:{r[0] = 9 + size * random.nextInt(z);}break;
                default: break;
            }
            
            for(k = 1; k < length; k++)
            {
                r[k] = r[k-1] + size;
            }
        }
        
        return r;
    }
}