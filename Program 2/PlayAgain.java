import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayAgain implements ActionListener
{    
    /**
     * Calls the methods necessary for replaying the game.
     * 
     * @param   evt the specific ActionEvent that was triggered
     */    
    public void actionPerformed(ActionEvent evt)
    {
        BattleshipFrame.eraseBoard();
        for (int i = 2; i <= 5; i++)
        {
            BattleshipFrame.populateBoard(i);
        }
        
        BattleshipFrame.playAgain.setVisible(false);//hides the window asking the user to play again           
    }
}