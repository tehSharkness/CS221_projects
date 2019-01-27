
/**
 * Write a description of class Driver here.
 * 
 * @author John Paxton
 * @version 1.0
 */

import java.util.Scanner;

public class Driver
{
    public static void main (String [] args)
    {
        BlackJackCard card1 = new BlackJackCard ();
        BlackJackCard card2 = new BlackJackCard ();
        Hand hand;
        
        Scanner in = new Scanner (System.in);
        
        card1.readSuit(in);
        card1.readRank(in);
        card1.setValue();
        
        card2.readSuit(in);
        card2.readRank(in);
        card2.setValue();
        
        hand = new Hand (card1, card2);
        hand.verifyHand();
        System.out.println("The value of the hand = " + hand.scoreHand());
        
    }
}
