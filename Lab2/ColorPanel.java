import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel
{
    ColorPanel()
    {
        setPreferredSize(new Dimension(300,300));
        setBackground(Color.white);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, 50, 50);
        g.drawString("Goal", 10, 30);
        x = getWidth() / 2;
        y = getHeight() / 2;
        g.fillOval(x, y, 10, 10);
    }    
    
    private int x;
    private int y;
}
