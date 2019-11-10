import java.util.*;
/**
 * LithiumPricing uses of Hashmaps to set the pricing of the 
 * lithium as this class is responsible for ensuring that each 
 * lithium sample is given a price. 
 *
 * @author (Lucy Mercer)
 * @version (Final 16/10/2019)
 */
public class LithiumPricing
{
    //Creating a new hashmap of double for price and array list for 
    //the tray values
    HashMap<Integer, Integer> pricing = new HashMap<Integer, Integer>();
    //Calls generate lithium class so that its methods can be 
    //used in this class
    GenerateLithium lithium;
    /**
     * Constructor for objects of class LithiumPricing
     */
    public LithiumPricing(GenerateLithium lithium)
    {
        this.lithium = lithium;
    }

    /**
     * Calculates what grade each piece of lithium should be and 
     * adds them to an arraylist based on their grade.
     * Adds the price and arrays to a hashmap.
     * 
     * @param GenerateLithium lithium allows for tray to be used
     * @return returns the hashmap that has been created
     */
    HashMap<Integer, Integer> setPrice()
    {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                if (lithium.tray[i][j] >= 1 && lithium.tray[i][j] <= 9){
                    pricing.put(lithium.tray[i][j], 300);
                }else if(lithium.tray[i][j] >= 10 && lithium.tray[i][j] <= 19){
                    pricing.put(lithium.tray[i][j], 600);
                }else if(lithium.tray[i][j] >= 20 && lithium.tray[i][j] <= 29){
                    pricing.put(lithium.tray[i][j], 900);
                }else if(lithium.tray[i][j] >= 30){
                    pricing.put(lithium.tray[i][j], 1250);
                }
            }
        }
        //returns the hashmap
        return pricing;
    }

    /**
     * Prints all of the grades and prices of every piece of 
     * lithium from the generated tray.
     */
    public void printPrice()
    {
        for(Map.Entry e : pricing.entrySet()){
            System.out.println("Grade: " + e.getKey() 
                + " Price: " + e.getValue());
        }
    }
}
