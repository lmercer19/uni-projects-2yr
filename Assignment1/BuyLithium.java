import java.util.*;
/**
 * This class has 2 methods findBestPrice and findHighQuality
 * 
 * The output of the methods is to show all the lithium grades 
 * with their prices as well as indicate to the buyer the number
 * of lithium grades available
 *
 * @author (Lucy Mercer)
 * @version (Final 21/10/19)
 */
public class BuyLithium
{
    //calls the GenerateLithium class so that its methods
    //can be used in this class
    LithiumPricing lithium;
    //creates a temparary hashmap
    HashMap<Integer, Integer> temp1 = new HashMap<Integer, Integer>(); 
    /**
     * Constructor for objects of class BuyLithium
     */
    public BuyLithium(LithiumPricing lithium)
    {
        this.lithium = lithium;
        //populates new hashmap with old hashmap
        temp1.putAll(lithium.pricing);
    }

    /**
     * Iterates through a temporary array list and removes values 
     * that are above the price specified.
     * @param int price, lets user enter a price that they 
     * wish to pay
     */
    public void findBestPrice(int price)
    {
        //creates iterator for the hashmap temp1
        Iterator<Map.Entry<Integer, Integer>> it = temp1.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getValue() > price){
                it.remove();
            }
        }
        int x = temp1.size();
        System.out.println(temp1);
        System.out.println("There are " + x + " choices available to you.");
        System.out.println();
        //repopulates hashmap with original values so that you can 
        //search again
        temp1.putAll(lithium.pricing);
    }

    /**
     * Iterates through a temporary array list and removes
     * values that are below the grade specified.
     * @param int grade, lets user enter a minimum grade they 
     * wish to purchase.
     */
    public void findHighQuality(int grade)
    {
        //creates iterator for the hashmap temp1
        Iterator<Map.Entry<Integer, Integer>> it = temp1.entrySet().iterator(); 

        while(it.hasNext()) 
        {
            Map.Entry<Integer, Integer> entry = it.next();
            if(entry.getKey()<= grade){
                it.remove();
            }
        } 
        int x = temp1.size();
        System.out.println(temp1);
        System.out.println("There are " + x + " choices available to you.");
        System.out.println();
        //repopulates hashmap with original values so that you can 
        //search again
        temp1.putAll(lithium.pricing);
    }
}
