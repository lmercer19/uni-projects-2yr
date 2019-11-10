
/**
 * Enumeration class Item
 * The items in the game.
 * 
 * @author Olaf Chitil and Lucy Mercer
 * @version 19/2/2019
 */
public enum Item
{
    // A value for each item along with its
    // corresponding user interface string.
    FLOUR("flour"),
    
    SUGAR("sugar"),
    
    EGG("egg");
    
    //The item string
    private String itemString;
    /**
     * Initialise with the corresponding item string.
     * @param itemString The item string.
     */
    Item(String itemString)
    {
        this.itemString = itemString;
    }
    
    /**
     * @return the description of the item.
     */
    public String toString()
    {
        return itemString;
    }
}
