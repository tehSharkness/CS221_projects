import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Creates a panel for displaying gameplay information.
 */
public class InfoPanel extends JPanel
{
    public static int numberOfGuesses;//the number of guesses made
    
    public static int hit;//the number of hits
    
    public static JLabel guesses;//contains the integer numberOfGuesses   
    
    private static MyFrame parent;//used in building the 
    
    private JButton eight, ten;//determines what the size of the game will be
    
    private JLabel lab;//asks what the size of the game is
        
    /**
     * Class Constructor.
     */    
    public InfoPanel(MyFrame p)
    {
        numberOfGuesses = 0;
        hit = 0;
        
        guesses = new JLabel("Guesses: " + numberOfGuesses);
        add(guesses);
        guesses.setForeground(Color.red);
        parent = p;        
        setPreferredSize(new Dimension(800,125));
        
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
        Color[] color = {Color.black, Color.green, Color.blue, Color.red, Color.yellow};
        String[] str = {"Miss", "Minesweeper (2)", "Frigate (3)", "Cruiser (4)", "Battleship (5)"};
        
        super.paintComponent(g);
        setBackground(Color.white);
        g.setColor(Color.black);
        g.drawRect(0,0,799,124);        
        
        for(int i = 0, j = 20; i < 5; i++, j += 15)
        {
            g.setColor(color[i]);
            g.fillRect(5,j,10,10);
            g.setColor(Color.black);
            g.drawString(str[i],20,10 + j);
        }
        
        if(hit == 13)
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
    
    public static class PlayAgain implements ActionListener
    {        
        /**
         * Calls the methods necessary for replaying the game.
         * 
         * @param   evt the specific ActionEvent that was triggered
         */        
        public void actionPerformed(ActionEvent evt)
        {           
            new MyFrame();
        }        
    }
    
    public static class ExitGame implements ActionListener
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
            MyPanel.size = Integer.parseInt(pa.getText());
            parent.panel = new MyPanel(parent);
            parent.add(parent.panel);
            parent.pack();
            parent.info.remove(parent.info.eight);
            parent.info.remove(parent.info.ten);
            parent.info.remove(parent.info.lab);
        }
    }
}