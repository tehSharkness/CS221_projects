/**
 * Used as a place-holder in the LinkedList class.
 * This code was adapted from the lecture code used in class.
 * 
 * @author  Sam Harkness
 * @version 1.0
 */
public class Node
{
    /**
     * Constructs a node.
     * 
     * @param   index   The number designation of the node in a LinkedList.
     */
    Node(int index)
    {
        this.index = index;
        this.next = null;
        this.previous = null;
    }
    
    /**
     * Sets the next pointer of this node.
     * 
     * @param   what    The node that is pointed to.
     */
    public void setNext(Node what)
    {
        this.next = what;
    }
    
    /**
     * Sets the previous pointer of this node.
     * 
     * @param   what    The node that is pointed to.
     */
    public void setPrevious(Node what)
    {
        this.previous = what;
    }
        
    /**
     * Returns the next node in the LinkedList.
     * 
     * @return  The next node.
     */
    public Node getNext()
    {
        return next;
    }
    
    /**
     * Returns the previous node in the LinkedList.
     * 
     * @return  The previous node.
     */
    public Node getPrevious()
    {
        return previous;
    }
    
    /**
     * Returns the number designation of this candidate.
     * 
     * @return  The number designation of this candidate.
     */
    public int getIndex()
    {
        return index;
    }
    
    private int index;//The number designation of this candidate.
    private Node next;//The next node in the LinkedList class.
    private Node previous;//The previous node in the LinkedList class.
}
