import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Simulates solitaire play of the game Battleship.  Try to locate all parts of all 5 enemy ships.
 * Extends the JFrame class.
 * 
 * @author  Spencer DeBuf
 * @version 1.0 
 */
public class BattleshipFrame extends JFrame
{    
    private SquarePanel panel[][] = new SquarePanel[8][8];//the playing grid
    
    private static JButton button[][] = new JButton[8][8];//the buttons on the playing grid
    
    private static InfoPanel info;//displays game info
    
    private JFrame playAgain;//asks if the game should be played again
    
    private static Color defaultColor;//the color of each JButton
    
    private static int guesses = 0;//the number guesses of made
    
    public static int board[][] = new int[8][8];//stores the location of the ships
    
    /**
     * Class Constructor.  Displays the playing field on the JFrame
     */
    public BattleshipFrame()
    {
        info = new InfoPanel();           
        add(info);//adds the InfoPanel to the bottom of the JFrame     
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(425,545));
        setLayout(new FlowLayout(1,0,0));
        setVisible(true);
        setTitle("Battleship"); 
        setResizable(false);
        
        //populates the board with panels with JButtons on them
        for (int r = 0; r < 8; r++)
        {
            for (int c = 0; c < 8; c++)
            {                
                panel[r][c] = new SquarePanel();
                button[r][c] = new JButton();
                panel[r][c].setLayout(new FlowLayout());
                button[r][c].setPreferredSize(new Dimension(48,48));
                button[r][c].addActionListener(new ButtonPressed(r,c));
                panel[r][c].add(button[r][c]);
                add(panel[r][c]);
            }
        }              
        
        defaultColor = button[1][1].getBackground();//set the default Color of the JButtons                   
        pack(); 
        
        eraseBoard();        

        for (int i = 2; i <= info.BATTLESHIP; i++)
        {
            populateBoard(i);
        }
    }    
    
    /**
     * Clears the play area for a new game.
     */    
    public static void eraseBoard()
    {
        guesses = 0;
        for (int x1 = 0; x1 < 8; x1++)
        {
            for (int y1 = 0; y1 < 8; y1++)
            {
                board[x1][y1] = 0;  //erases the placement of the ships
                button[x1][y1].setBackground(defaultColor);//sets the buttons to their default color
            }            
        }
        
        info.guesses.setText("Guesses: " + guesses);//displays the number of guesses
    }
    
    /**
     * Class to be called when the buttons are pressed.  Implements ActionListener Interface.
     */    
    public class ButtonPressed implements ActionListener
    {   
        private int r;//integer to store the value of which row the button that was pressed is in
        private int c;//integer to store the value of which column the button that was presses is in
        
        /**
         * Class Constructor.
         * 
         * @param   row which row the button pressed resides in
         * @param   column  which column the butotn pressed resides in
         */        
        public ButtonPressed(int row, int column)
        {
            r = row;
            c = column;
        }
        
        /**
         * Checks if the guess was a hit or miss.  Displays the result on the JFrame.
         * 
         * @param   evt the specific ActionEvent that was triggered
         */        
        public void actionPerformed(ActionEvent evt)
        {
            button[r][c].removeActionListener(this);
            
            //if the guess was a miss            
            if (board[r][c] == 0)
            {
                button[r][c].setBackground(Color.black);
                board[r][c] = 0;
            }
            
            //if the guess hit a minesweeper
            if (board[r][c] == 2)
            {
                button[r][c].setBackground(Color.green);
                board[r][c] = -1;
            }
            
            //if the guess hit a frigate
            if (board[r][c] == 3)
            {
                button[r][c].setBackground(Color.blue);
                board[r][c] = -1;
            }
            
            //if the guess hit a cruiser
            if (board[r][c] == 4)
            {
                button[r][c].setBackground(Color.red);
                board[r][c] = -1;
            }
            
            //if the guess hit a battleship
            if (board[r][c] == 5)
            {
                button[r][c].setBackground(Color.yellow);
                board[r][c] = -1;
            }
            
            guesses++;
            info.guesses.setText("Guesses: " + guesses);     
            
            info.repaint();
        }           
    }
    
    
    
    /**
     * Fills the board randomly with the 4 ships.
     * 
     * @param   lengthOfShip    the length of the specific ship currently being placed
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
                        if (board[x][i] != 0)
                        {
                            emptySquare = false;
                        }
                    }  
                
                    //ship can be placed here
                    if (emptySquare)
                    {
                        for (int i = y; i < y + length; i++)
                        {
                            board[x][i] = length;
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
                        if (board[i][y] != 0)
                        {
                            emptySquare = false;
                        }
                        
                    }
                    
                    //ship can be placed here
                    if (emptySquare)
                    {
                        for (int i = x; i > x - length; i--)
                        {
                            board[i][y] = length;                              
                        
                        }
                        return;
                    }
                }               
            }
        }           
    }    
}

