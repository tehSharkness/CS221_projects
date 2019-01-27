import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.BorderLayout;

public class MouseFrame extends JFrame
{
    MouseFrame ()
    {
        getContentPane().add(new MousePanel(), BorderLayout.CENTER);
        setPreferredSize(new Dimension(600, 300));
        pack();
        setVisible(true);
    }
}
