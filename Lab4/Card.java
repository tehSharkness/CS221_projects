/**
 * This class represents a single playing card such as the 10 of hearts.
 * 
 * @author John Paxton
 * @version 1.0
 */


import java.util.Scanner;

public class Card
{
    Card (String suit, String rank)
    {
        this.suit = suit;
        this.rank = rank;
    }
    
    private void verifySuit()
    {
    }
    
    private void verifyRank()
    {
    }
    
    public void readSuit (Scanner in) 
    {
        System.out.print("Please enter the suit (clubs, diamonds, hearts, spades) for card > ");
        suit = in.next();
        verifySuit();
    }
    
     public void readRank (Scanner in) 
    {
        System.out.print("Please enter the rank (two, three, ..., ace) for card > ");
        rank = in.next();
        verifyRank();
    }
    
    public void setSuit (String suit)
    {
        this.suit = suit;
    }
       
    public String getSuit()
    {
        return suit;
    }
    
    public void setRank (String rank)
    {
        this.rank = rank;
    }
    
    public String getRank()
    {
        return rank;
    }
    
    protected String suit;
    protected String rank;
}
