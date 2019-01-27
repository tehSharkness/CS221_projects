/**
 * A circular, double-linked list.
 * This code was adapted from the code in class.
 * 
 * @author  Sam Harkness
 * @version 1.0
 */
public class LinkedList<E>
{
    /**
     * Constructs a LinkedList of length N.
     * 
     * @param   N   The number of nodes in the linked list.
     */
    LinkedList(int N)
    {
        first = new Node(0);
        first.setNext(first);
        first.setPrevious(first);
        
        for(int i = 1; i <= N; i++)
        {
            add(new Node(i));
        }
    }
    
    /**
     * Adds a node to the end of the list.
     * 
     * @param   applicant   The node that is being added.
     */
    public void add(Node applicant)
    {
        Node before = first.getPrevious();
        Node after = before.getNext();
        
        before.setNext(applicant);
        after.setPrevious(applicant);
        applicant.setNext(after);
        applicant.setPrevious(before);
    }
    
    /**
     * Removes the node at the specified index.
     * 
     * @param   index   The position of the node to be removed.
     */
    public void remove(int index)
    {
        Node victim = first.getNext();
        
        while((victim.getIndex() != first.getIndex()) && (victim.getIndex() != index))
        {
            victim = victim.getNext();
        }
        
        Node before = victim.getPrevious();
        Node after = victim.getNext();
        
        before.setNext(after);
        after.setPrevious(before);
        
        if(victim.getIndex() == first.getIndex())
        {
            first = after;
        }
    }
    
    public static Node first;//The first node of the list.
}
