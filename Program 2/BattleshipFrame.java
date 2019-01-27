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
    private SquarePanel panel[][];//the playing grid of 8 rows by 8 columns
    
    public static JButton button[][];//the 64 possible guesses
    
    public static InfoPanel info;//displays gameplay information
    
    public static JFrame playAgain;//contains a question dialog displayed at the end of a game
    
    static int length;//the length of the ship, used in the placement of the ships
    
    public static int board[][];//used for storing the locations of the ships
    
    public BattleshipFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//         setPreferredSize(new Dimension(425,525));
        getContentPane().setLayout(new FlowLayout(1,0,0));
        setVisible(true);
        setTitle("Battleship"); 
        setResizable(false);
        
        panel = new SquarePanel[8][8];
        button = new JButton[8][8];
        board = new int[8][8];
        
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
                getContentPane().add(panel[r][c]);
            }
        }              
        
        info = new InfoPanel();           
        getContentPane().add(info);//adds the InfoPanel to the bottom of the JFrame        
        pack();      
    }    
    
    /**
     * Clears the play area for a new game.
     */    
    public static void eraseBoard()
    {
        for (int x1 = 0; x1 < 8; x1++)
        {
            for (int y1 = 0; y1 < 8; y1++)
            {
                board[x1][y1] = 0;  //erases the placement of the ships
                button[x1][y1].setBackground(Color.black);//sets the buttons to their default color
            }            
        }
        
        info.guesses.setText("Guesses: " + info.numberOfGuesses);//displays the number of guesses
    }
    
    /**
     * Checks if all of the ships have been hit.
     * 
     * @return  false if the game is not over, true if the game is over
     */    
    public static boolean checkForGameOver()
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                //if the board doesnt contain a ship or if it contains a ship but the position has already been located
                if (board[row][col] != 0 && board[row][col] != -1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Fills the board randomly with the 4 ships.
     * 
     * @param   lengthOfShip    the length of the specific ship currently being placed
     */    
    public static void populateBoard(int lengthOfShip)
    {
        /** instance */
        Random random = new Random();//used for randomly placing the ships
        
        /** */
        boolean cont = false;//used to tell the loop whether to keep trying to place the ship or not
        
        /** */
        boolean orientation = false;//used to designate whether the ship should go backwards or forwards
        
        /** used to designate whether the ship should be placed horizontally or vertically*/
        boolean direction;
        
        /**integer representing the potential x value of the ship position*/
        int x;
        
        /**integer representing the potential y value of the ship position*/
        int y;
        
        /** integer representing whethere a specific square is empty or not*/
        boolean emptySquare = true;
        
        length = lengthOfShip;
        
        while (!cont)
        {    
            emptySquare = true;        
        
            orientation = random.nextBoolean();
            direction = random.nextBoolean();
        
            x = random.nextInt(8);
            y = random.nextInt(8);            
       
            //vertical
            if (orientation)
            {            
                //placed to the right
                if (direction)
                {
                
                    //both points are one the board
                    if (y + length <= 7)
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
                
                //placed to the left
                else
                {
                    if (y - length >= 0)
                    {
                        for (int i = y; i > y - length; i--)
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
                            for (int i = y; i > y - length; i--)
                            {
                            
                                board[x][i] = length;                                           
                                                             
                            }
                            return;
                        }
                    }
                }
                    
            }            
        
            //horizontal
            if (!orientation)
            {
                //placed upward
                if (!direction)
                {           
                    //both points are one the board
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
                
                //placed downward
                else
                {
                    if (x + length <= 7)
                    {
                        for (int i = x; i < x + length; i++)
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
                            for (int i = x; i < x + length; i++)
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
    
//     public int[][] setPosition(int length, int ship)
//     {
//         int[][] r = new int[length][length];
//         boolean orient = random.nextBoolean();//randomly determines the orientation
//         if(orient)//the ship is horizontal
//         {   
//             
//             r[random.nextInt(length - ship)][random.nextInt(length)] = ship;
//                         
//             for(k = 1; k < length; k++)
//             {
//                 r[k] = r[k-1] + 1;
//             }
//         }
//         else//the ship is vertical
//         {
//             switch(1 + random.nextInt(8))//randomly determines which column the ship is in
//             {
//                 case 1:{r[0] = 8 * random.nextInt(z);}break;
//                 case 2:{r[0] = 1 + 8 * random.nextInt(z);}break;
//                 case 3:{r[0] = 2 + 8 * random.nextInt(z);}break;
//                 case 4:{r[0] = 3 + 8 * random.nextInt(z);}break;
//                 case 5:{r[0] = 4 + 8 * random.nextInt(z);}break;
//                 case 6:{r[0] = 5 + 8 * random.nextInt(z);}break;
//                 case 7:{r[0] = 6 + 8 * random.nextInt(z);}break;
//                 case 8:{r[0] = 7 + 8 * random.nextInt(z);}break;
//                 default: break;
//             }
//             
//             for(k = 1; k < length; k++)
//             {
//                 r[k] = r[k-1] + 8;
//             }
//         }
//         
//         return r;
//     }
    
    public class ButtonPressed implements ActionListener
    {   
        private int r;//integer to store the value of which row the button that was pressed is in
        private int c;//integer to store the value of which column the button that was presses is in
        private Color[] color = {Color.black, null, Color.green, Color.blue, Color.red, Color.yellow};
        
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
            for(int i = 0; i < 6; i++)
            {
                if(board[r][c] == i)
                {
                    button[r][c].setBackground(color[i]);
                }
                if(board[r][c] != 0)
                {
                    board[r][c] = -1;
                }
            }
                    
            info.numberOfGuesses++;
            info.guesses.setText("Guesses: " + info.numberOfGuesses);     
            
            if (checkForGameOver())
            {
                info.checkForPlayAgain();
            }           
        }
    }
}

