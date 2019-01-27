import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorFrame extends JFrame
{
    ColorFrame()
    {       
        
        panel = new ColorPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        
        fileMenu.add(new ExitItem("Exit"));
        
        JMenu moveMenu = new JMenu("Move");
        menuBar.add(moveMenu);
        
        moveMenu.add(createMoveItem("Up"));
        moveMenu.add(createMoveItem("Down"));        
        moveMenu.add(createMoveItem("Left"));
        moveMenu.add(createMoveItem("Right"));
        
        pack();
        setVisible(true);
    }
    
    public JMenuItem createMoveItem(String label)
    {
        JMenuItem item = new JMenuItem(label);
        
        class MenuItemListener implements ActionListener
        {
            public void actionPerformed (ActionEvent evt)
            {
                
            }
        }
        item.addActionListener(new MenuItemListener());
        return item;
    }
    
    class ExitItem extends JMenuItem implements ActionListener
    {
        ExitItem(String label)
        {
            setText(label);
            addActionListener(this);
        }

        public void actionPerformed (ActionEvent evt)
        {
            System.exit(0);
        }
    }
    
    class Puck
    {
        Puck()
        {
            
        }
    }
            
    private ColorPanel panel;
}
