/**
 * Creates the buttons used for the battleship game.
 * 
 * @author  Samuel Harkness
 * @version 1.0
 */
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class MyButton extends JButton implements ActionListener
{
    private Color color;//the color that is displayed when the button is clicked on
    
    private MyFrame parent;//used to restart the game
    
    /**
     * The constructor for MyButton.
     * 
     * @param   c     The color that the button changes to when the button is clicked.
     * @param   p     The frame used to hold the frame.
     */
    public MyButton(Color c, MyFrame p)
    {
        addActionListener(this);
        setPreferredSize( new Dimension( 100,100 ) );
        color = c;
        parent = p;
    }
    
    /**
     * The method called when a button is clicked on.
     * 
     * @param   evt   The event that occurred.
     */
    public void actionPerformed( ActionEvent evt )
    {
        if(parent.info.hit != 14)
        {
            setBackground(color);
        
            if(color != color.black)
            {
                parent.info.hit += 1;
            }
            
            parent.info.numberOfGuesses += 1;
            parent.info.guesses.setText("Guesses: " + parent.info.numberOfGuesses);
            removeActionListener(this);//disables this button being clicked on
        }
            
        parent.info.repaint();
    }
}