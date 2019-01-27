//CS 221-05 inlab1 Samuel Harkness, Pat Thompson

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanamaFrame extends JFrame
{
    PanamaFrame()
    {
        Color red = new Color( 204, 0, 51 );
        JPanel one = new JPanel();
        one.setBackground( red );
        
        Color blue = new Color( 51, 51, 255 );
        JPanel two = new JPanel();
        two.setBackground( blue );
        
        setPreferredSize( new Dimension(450, 325 ) );
        setLayout( new GridLayout( 2, 2 ) );
        add( new StarPanel( 51, 51, 255 ) );
        add( one );      
        add( two );
        add( new StarPanel( 204, 0, 51 ) );        
        pack();
        setVisible( true );        
    }
}
