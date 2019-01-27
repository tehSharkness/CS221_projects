/**
 * Creates a program to simulate a single-player game of BattleShip.
 * Four ships are created: minesweeper; frigate; cruiser; and battleship.
 * Each ship is randomly placed in an 8X8 grid.
 * The game ends when all the ships have been found.
 * 
 * @author  Samuel Harkness
 * @version 1.0
 */
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Component;

public class MyFrame extends JFrame
{       
    public static MyPanel panel;//displays the buttons
    public static InfoPanel info;//displays the number of guesses
    
    /**
     * The standard constructor for the BattleShip game.
     */
    public MyFrame()
    {
        setTitle("Battleship");
        info = new InfoPanel(this);
        
        add(info, BorderLayout.SOUTH);
        pack();
        setVisible( true );        
    }
}