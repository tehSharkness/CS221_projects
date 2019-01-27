
/**
 * Write a description of class MousePanel here.
 * 
 * @author John Paxton
 * @version 1.0
 */

import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

public class MousePanel extends JPanel
{
    int x;
    int y;
    int i;
    
    MousePanel()
    {
        setBackground(Color.white);
        addMouseMotionListener(new MyMotionListener());
        addMouseListener(new MyMouseAdapter());
        points = new ArrayList<Point>();
        circle = new ArrayList<Point>();
    }
        
    class MyMouseAdapter extends MouseAdapter
    {        
        public void mouseClicked (MouseEvent evt)
        {
            x = evt.getX();
            y = evt.getY();
            circle.add(new Point(x,y));
            repaint();
        }
    }
    
    class MyMotionListener extends MouseMotionAdapter
    {    
        public void mouseDragged (MouseEvent evt)
        {
            x = evt.getX();
            y = evt.getY();
            points.add(new Point(x,y));
            repaint();
        }
    }

    public void paintComponent (Graphics g)
    {
        Point p;
        Point c;
        
        super.paintComponent(g);
        for (i = 0; i < points.size(); i++)
        {
            g.setColor(Color.black);
            p = points.get(i);
            x = (int) p.getX();
            y = (int) p.getY();
            g.drawLine(x - 5, y, x + 5, y);
            g.drawLine(x, y - 5, x, y + 5);
        }
        for(i = 0; i < circle.size(); i++)
        {            
            g.setColor(Color.yellow);
            c = circle.get(i);
            x = (int)c.getX();
            y = (int)c.getY();
            g.fillOval(x - 5, y - 5, 10, 10);
        }
    }
       
    private ArrayList<Point> points;
    private ArrayList<Point> circle;
}
