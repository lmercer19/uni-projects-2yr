import java.util.*;
/**
 * This class makes use of the tray of lithium generated in 
 * the GenerateLithium class so that the lithium can be graded.
 *
 * @author (Lucy Mercer)
 * @version (Final 15/10/2019)
 */
public class LithiumGrading
{
    //Creates two arraylists names lowGrade and highGrade
    ArrayList<Integer> lowGrade = new ArrayList();
    ArrayList<Integer> highGrade = new ArrayList();
    //Calls the GenerateLithium class so its methods
    //are able to be used in this class
    GenerateLithium lithium;
    /**
     * Constructor for objects of class LithiumGrading
     */
    public LithiumGrading(GenerateLithium lithium)
    {
        this.lithium = lithium;
    }

    /**
     * Generates the grades for the lithium and places them in 
     * either the array lowGrade or highGrade is theyre higher or
     * lower than 25 (quality checking)
     * 
     * @param GenerateLithium lithium allows for tray to be used
     */
    public void generateGrades()
    {
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                if(lithium.tray[i][j] < 25) {
                    lowGrade.add(lithium.tray[i][j]);
                }
                else{
                    highGrade.add(lithium.tray[i][j]);
                }
            }
        }
        System.out.println(lowGrade);
        System.out.println(highGrade);
    }

    /**
     * This method bubble sorts the two arrays so that they are 
     * in acending order.
     */
    public void sortingLithium()
    {
        int n = lowGrade.size();  
        int temp = 0;  
        for(int i = 0; i < n; i++){  
            for(int j = 1; j < (n-i); j++){  
                if(lowGrade.get(j-1) > lowGrade.get(j)){  
                    //swap elements  
                    temp = lowGrade.get(j-1);  
                    lowGrade.set(j-1, lowGrade.get(j));  
                    lowGrade.set(j,temp);  
                }  
            }  
        }  

        int h = highGrade.size();  
        int temp1 = 0;  
        for(int i=0; i < h; i++){  
            for(int j=1; j < (h-i); j++){  
                if(highGrade.get(j-1) > (highGrade.get(j))){  
                    //swap elements  
                    temp1 = highGrade.get(j-1);  
                    highGrade.set(j-1,highGrade.get(j));  
                    highGrade.set(j,temp1);  
                }  
            }  
        }  

        System.out.println("High grade:");  
        for(int i = 0; i < highGrade.size(); i++){  
            System.out.println(highGrade.get(i) + " ");  
        } 

        System.out.println("Low grade:");  
        for(int i = 0; i < lowGrade.size(); i++){  
            System.out.println(lowGrade.get(i) + " ");  
        } 
    }
}
