//import java.util.EnumSet;
/**
 * Class Character
 * A character in the game.
 * 
 * @author Olaf Chitil and Lucy Mercer
 * @version 19/2/2019
 */
public class Character
{
    private String description;
    private Item item;
    /**
     * Constructor initialising description and item.
     */
    public Character(String desc, Item it)
    {
        description = desc;
        item = it;
    }

    /**
     * Return the description and description of item if it exists.
     */
    public String toString()
    {
        if (item != null) {
            return description + " having the item " + item.toString();
        }
        return description;
    }

    /**
     * Take the given item from the character if it has that item.
     * Return whether item was taken.
     */
    public boolean take(Item it)
    {
        if (item == it) {
            item = null;
            return true;
        }
        
        return false;
    }
}
