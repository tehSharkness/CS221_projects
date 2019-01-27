//CS 221-05 inlab1 Samuel Harkness, Pat Thompson

import javax.swing.JPanel;

import java.awt.Polygon;
import java.awt.Color;
import java.awt.Graphics;

public class StarPanel extends JPanel
{      
    int[] x = { 110, 119, 146, 124, 133, 110, 89, 97, 74, 102, 110 };
    int[] y = { 44, 67, 67, 83, 110, 93, 110, 83, 67, 67, 44 };
    Color star;
    
    StarPanel( int r, int g, int b )
    {
        new Polygon( x, y, 11 );
        star = new Color( r, g, b );
    }
    
    public void paintComponent ( Graphics g )
    {
        super.paintComponent( g );
        setBackground( Color.white );
        g.setColor( star );
        g.fillPolygon( x, y, 11 );
    }
}
