import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Point;

/**
 * Creates a panel for displaying gameplay information.  Extends the JPanel class.
 */
public class InfoPanel extends JPanel
{
    public static int numberOfGuesses = 0;//the number of guesses made
    
    public static JLabel guesses;//contains the integer numberOfGuesses
           
    private Color[] color = {Color.black, Color.green, Color.blue, Color.red, Color.yellow};
    
    private String[] str = {"Miss", "Minesweeper (2)", "Frigate (3)", "Cruiser (4)", "Battleship (5)"};
        
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
    }
    
    /**
     * Paints the panel with the necessary information
     * 
     * @param   g   the graphics instance to be painted
     */    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        g.drawRect(0,0,399,99);
        
        
        for(int i = 0, j = 15; i < 6; i++, j += 15)
        {
            g.setColor(color[i]);
            g.fillRect(5,j,10,10);
            g.setColor(Color.black);
            g.drawString(str[i],20,10 + j);
        }                
    }
    
    public void checkForPlayAgain()
    {
    }    
}
