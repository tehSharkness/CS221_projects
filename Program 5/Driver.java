
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.PriorityQueue;
import java.util.Queue;

public class Driver
{
    private static Queue<State> previous;
    private static State state;
    
    public static void main(String[] args)
    {
        final int NUM = 3;
        previous = new PriorityQueue<State>();        
        state = new State(NUM, 0, NUM, 0, true);
        
        previous.offer(state);
        
        while(previous.peek() != null)
        {
            state = previous.peek();
            
            if(state.compareTo(new State(0, NUM, 0, NUM, false)))
            {
                break;
            }
            
            enqueue(2, 0);
            enqueue(1, 0);
            enqueue(1, 1);
            enqueue(0, 1);
            enqueue(0, 2);
        }
        
        Queue<State> temp = new PriorityQueue<State>();
        
        while(previous.peek() != null)
        {
            temp.offer(previous.poll());
        }
        
        while(temp.peek() != null)
        {
            temp.poll().print();
            System.out.println();
        }
    }
    
    private static void enqueue(int c, int m)
    {
        State temp = new State(state.leftCan, state.rightCan, state.leftMiss, state.rightMiss, state.left);
        
        boolean checkMove = temp.move(c, m);
        
        boolean checkPrevious = true;
        
        State[] stateArray = (State[]) previous.toArray(new State[0]);
        
        for(int i = 0; i < stateArray.length; i++)
        {
            if(temp.compareTo(stateArray[i]))
            {
                checkPrevious = false;
                break;
            }
        }
               
        if(checkMove && checkPrevious)
        {
            previous.offer((State)temp);
        }
    }
}
