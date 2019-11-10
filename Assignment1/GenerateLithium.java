import java.util.*;
/**
 * This class randomly generates a 2d array called "tray" which 
 * holds the values of all the lithium.
 * has 2 methods, generateSample, and printTray.
 *
 * @author (Lucy Mercer)
 * @version (Final 15/10/2019)
 */
public class GenerateLithium
{   
    //Creates the 2d array named tray 
    int tray [][] = new int [5][3];
    //Calls the random generator
    private Random randomGenerator;
    /**
     * Constructor for objects of class GenerateLithium
     */
    public GenerateLithium()
    {
        randomGenerator = new Random();
    }
    
    /**
     * Randomly generates numbers up to 50 and enters them
     * into the 2d array.
     */
    public void generateSample()
    {
        for (int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                tray[i][j] = randomGenerator.nextInt(50);
            }
        }
    }
    
    /**
     * Outputs the tray and all of its values.
     */
    public void printTray()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(tray[i][j] + "||");
            }
            System.out.println();
        }
    }
}