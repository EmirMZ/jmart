package EmirMuhamadZaidJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jmart
{
    static int getPromo() {
        System.out.println("I just got executed!");
        return 0;
    }
   
    static String getCustomer() {
        
        System.out.println("I just got executed!");
        return "OOP";
    }
    
    static float getDiscountPercentage(int before, int after) {
        if(before>after){
            before = before-after;
            before = before/100;
        }else{
            before = 0;
        }
        System.out.println("I just got executed!");
        return before;
    }

    static void getDiscountedPrice() {
        System.out.println("I just got executed!");
    }

    static void getOriginalPrice() {
        System.out.println("I just got executed!");
    }
     
    static void getCommissionMultiplier() {
        System.out.println("I just got executed!");
    }
    
    static void getAdjustedPrice() {
        System.out.println("I just got executed!");
    }

    static void getAdminFee() {
        System.out.println("I just got executed!");
    }
}
