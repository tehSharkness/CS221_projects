
/**
 * Write a description of class Hand here.
 * 
 * @author John Paxton
 * @version 1.0
 */

public class Hand
{
    Hand (BlackJackCard c1, BlackJackCard c2)
    {
        card1 = c1;
        card2 = c2;
    }
    
    public void verifyHand ()
    {
    }
    
    public int scoreHand ()
    {
        return card1.getValue() + card2.getValue();
    }
    
    BlackJackCard card1;
    BlackJackCard card2;
}
