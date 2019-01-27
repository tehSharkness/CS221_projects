import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates a panel for displaying gameplay information.  Extends the JPanel class.
 */
public class InfoPanel extends JPanel
{
    private int numberOfGuesses = 0;//number of guesses made
    
    public JLabel guesses;//displays the numberOfGuesses
    
    public static int BATTLESHIP;
    
    private static BattleshipFrame parent;//used in building the game board
    
    private JButton eight, ten;//determines what the size of the game will be
    
    private JLabel lab;//asks what the size of the game is

    /**
     * Class Constructor.
     */    
    public InfoPanel()
    {
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(400,100));        
        guesses = new JLabel("Guesses: " + numberOfGuesses);
        guesses.setForeground(Color.red);
        add(guesses);
        
        eight = new JButton();
        ten = new JButton();
        lab = new JLabel("Please select a playing grid:");
        
        eight.addActionListener(new GetGrid(eight));
        ten.addActionListener(new GetGrid(ten));
        
        eight.setText("8");
        ten.setText("10");
        
        add(lab);
        add(eight);
        add(ten);
    }
    
    /**
     * Paints the panel with the necessary information
     * 
     * @param   g   the graphics instance to be painted
     */    
    public void paintComponent(Graphics g)
    {   
        String[] str = {"Miss", "Minesweeper (2)", "Frigate (3)", "Cruiser (4)", "Battleship (5)"};
        Color[] color = {Color.black, Color.green, Color.blue, Color.red, Color.yellow};     
        
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        g.drawRect(0,0,399,99);        
        
        for(int i = 0, j = 15; i < 5; i++, j += 15)
        {
            g.setColor(color[i]);
            g.fillRect(5,j,10,10);
            g.setColor(Color.black);
            g.drawString(str[i],20,10 + j);
        }
        
        if(checkForGameOver())
        {
            JButton yes = new JButton("Yes");
            JButton no = new JButton("No");
            JLabel playAgainLabel = new JLabel("Play again?");
            add(playAgainLabel);
            add(yes);
            add(no);
            no.addActionListener(new ExitGame());
            yes.addActionListener(new PlayAgain());
        }
    }
    
    /**
     * Exits the application.  Implements the ActionListener Interface
     */    
    public class ExitGame implements ActionListener
    {        
        /**
         * Exits the application.
         * 
         * @param   evt the specific ActionEvent that was triggered
         */        
        public void actionPerformed(ActionEvent evt)
        {
            System.exit(0);
        }
    }
    
    /**
     * Calls the methods necessary for replaying the game.  Implements the ActionListener Interface.
     */    
    public class PlayAgain implements ActionListener
    {        
        /**
         * Calls the methods necessary for replaying the game.
         * 
         * @param   evt the specific ActionEvent that was triggered
         */        
        public void actionPerformed(ActionEvent evt)
        {
            BattleshipFrame.eraseBoard();
            for (int i = 2; i <= 5; i++)
            {
                BattleshipFrame.populateBoard(i);
            }
            
        }
    }
    
    /**
     * Checks if all of the ships have been hit.
     * 
     * @return  false if the game is not over, true if the game is over
     */    
    public boolean checkForGameOver()
    {
        for (int row = 0; row < 8; row++)
        {
            for (int col = 0; col < 8; col++)
            {
                //if the board doesnt contain a ship or if it contains a ship but the position has already been located
                if (BattleshipFrame.board[row][col] != 0 && BattleshipFrame.board[row][col] != -1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static class GetGrid implements ActionListener
    {   
        JButton pa;
        GetGrid(JButton p)
        {
            pa = p;
        }
        /**
         * Reads the text of the button to find the size of the grid
         * 
         * @param   evt the specific ActionEvent that was triggered
         */
        public void actionPerformed(ActionEvent evt)
        {
            parent.size = Integer.parseInt(pa.getText());
            
            parent.add(parent.panel, BorderLayout.CENTER);
            parent.pack();
            parent.info.remove(parent.info.eight);
            parent.info.remove(parent.info.ten);
            parent.info.remove(parent.info.lab);
        }
    }
}
