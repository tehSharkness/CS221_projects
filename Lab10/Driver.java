import java.util.LinkedList;
import java.util.ListIterator;

public class Driver
{
    public static void main (String [] args)
    {
        LinkedList<Song> list = new LinkedList<Song>();
        
        Song song;
        
        song = new Song("I Cant Get No Satisfaction", "Rolling Stones", 1965);
        list.addFirst(song);
        
        song = new Song("A Hard Day's Night", "Beatles", 1964);
        addInOrder(song, list);
        
        song = new Song("Jumpin' Jack Flash", "Rolling Stones", 1968);
        addInOrder(song, list);
        
        song = new Song("Not Fade Away", "Rolling Stones", 1964);
        addInOrder(song, list);        
        
        song = new Song("Michelle", "Beatles", 1965);
        addInOrder(song, list);
        
        System.out.println("Forwards Print\n");
        print(list);
        
        list.remove();
        
        System.out.println("\nForwards Print\n");
        print(list);
        
        System.out.println("\nBackwards Print\n");
        printBackwards(list);
    }    
    
    public static void addInOrder(Song data, LinkedList<Song> list)
    {
        ListIterator<Song> iterator = list.listIterator();
        
        Song after = iterator.next();
        
        while(iterator.hasNext() && (data.compareTo(after) > 0))
        {
            after = iterator.next();
        }
        
        iterator.previous();
        iterator.add(data);
    }
    
    public static void print(LinkedList<Song> list)
    {
        ListIterator<Song> iterator = list.listIterator();
        
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }
    
    public static void printBackwards(LinkedList<Song> list)
    {
        ListIterator<Song> iterator = list.listIterator(list.size());
        
        while(iterator.hasPrevious())
        {
            System.out.println(iterator.previous());
        }
    }    
}
