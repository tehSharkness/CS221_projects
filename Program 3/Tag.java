/**
 * Stores information about an html tag and the number of times it appears.
 * 
 * @author  Sam Harkness
 * @version 3/2/06
 */
public class Tag
{
    public static String name;//The title of the tag.
    public static int count;//The number of times the tag appears.
    
    /**
     * Establishes a tag with both a name and a count.
     * 
     * @param   str    The title of the tag.
     * @param   c      The number of times the tag appears.
     */
    public Tag(String str, int c)
    {
        name = str;
        count = c;
    }
    
    /**
     * Returns the title of the tag.
     * 
     * @return  The title of the tag.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Returns the number of times the tag appears.
     * 
     * @return  The number of times the tag appears.
     */
    public int getCount()
    {
        return count;
    }
}