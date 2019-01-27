
/**
 * Write a description of class State here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class State
{
    public int leftCan;
    public int rightCan;
    public int leftMiss;
    public int rightMiss;
    public boolean left;
    
    State(int lC, int rC, int lM, int rM, boolean bool)
    {
        leftCan = lC;
        rightCan = rC;
        leftMiss = lM;
        rightMiss = rM;
        left = bool;
    }
    
    public boolean move(int c, int m)
    {        
        if(left)
        {
            if((leftCan >= c) && (leftMiss >= m))
            {
                left = false;
                leftCan = leftCan - c;
                rightCan = rightCan + c;
                leftMiss = leftMiss - m;
                rightMiss = rightMiss + m;
            }
            else
            {
                return false;
            }
        }
        else
        {
            if((rightCan >= c) && (rightCan >= m))
            {
                left = true;
                leftCan = leftCan + c;
                rightCan = rightCan - c;
                leftMiss = leftMiss + m;
                rightMiss = rightMiss - m;
            }
            else
            {
                return false;
            }
        }
        
        if((leftMiss >= leftCan) || (leftMiss == 0))
        {
            if((rightMiss >= rightCan) || (rightMiss == 0))
            {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean compareTo(State check)
    {
        if((this.leftCan == check.leftCan) &&
           (this.rightCan == check.rightCan) &&
           (this.leftMiss == check.leftMiss) &&
           (this.rightMiss == check.rightMiss) &&
           (this.left == check.left))
        {
            return true;
        }
        return false;
    }
    
    public void print()
    {
        System.out.println("Left Cannibals: " + leftCan + "\tRight Cannibals: " + rightCan);
        System.out.println("Left Missionaries: " + leftMiss + "\tRight Missionaries: " + rightMiss);
        
        if(left)
        {
            System.out.println("The boat is on the left.");            
        }
        else
        {
            System.out.println("The boat is on the right.");
        }
        
        System.out.println();
    }
}
