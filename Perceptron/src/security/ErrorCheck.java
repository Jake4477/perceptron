
package security;


/**
 * Jan 20, 2022
 * @author Jake
 * Teacher: Mr. Wachs
 * Description: Checks if the user input is valid
 */
public class ErrorCheck {
    //constructor
 
    /**
     * checks to see if a valid int was entered. 
     * @param <T> For analysis 
     * @param item the value passed that is getting checked
     * @return if valid returns value. If invalid returns -1.
     */
    public static <T> double checkDouble(T item){
        try{
            double value = Double.parseDouble(item.toString());
            return value;
        }catch(NumberFormatException e){
            System.out.println("Not Valid Key Entered");
        }catch(Exception e){
            System.out.println("Something Went Wrong :(. "
                    + "It wasn't a number issue tho");
        }
       return -1;
    }
    
}
