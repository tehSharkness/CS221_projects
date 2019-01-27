
/**
 * This class represents a single card for the game of BlackJack.
 * 
 * @author John Paxton
 * @version 1.0
 */

public class BlackJackCard extends Card
{
    BlackJackCard ()
    {
        super("no suit", "no rank");
    }
    
    public void setValue ()
    {
        value = 0;
        
        if (rank.equals("two"))         { value = 2; }
        else if (rank.equals("three"))  { value = 3; }
        else if (rank.equals("four"))   { value = 4; }
        else if (rank.equals("five"))   { value = 5; }
        else if (rank.equals("six"))    { value = 6; }
        else if (rank.equals("seven"))  { value = 7; }
        else if (rank.equals("eight"))  { value = 8; }
        else if (rank.equals("nine"))   { value = 9; }
        else if ((rank.equals("ten")) || (rank.equals("jack")) ||
                 (rank.equals("queen")) || (rank.equals("king"))) 
                                        { value = 10; }
        else if (rank.equals("ace"))    { value = 11; }
    }
    
    public int getValue()
    {
        return value;
    }
    
    private int value;
}
