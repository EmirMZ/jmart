package EmirMuhamadZaidJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */


public class Jmart
{
    public static void main(String[] args) {
        System.out.println("getPromo() = " + getPromo());
        System.out.println("getCustomer() = " + getCustomer());
        System.out.println("getDiscountPercentage(100,50) = " + getDiscountPercentage(100,50));
        System.out.println("getDiscountedPrice(2500,60.0f) = " + getDiscountedPrice(100,60.0f));
        System.out.println(getPromo());
        System.out.println(getPromo());
    }
    
    static int getPromo() {
       //System.out.println("I just got executed!");
        return 0;
    }
   
    static String getCustomer() {
        
        //System.out.println("I just got executed!");
        return "OOP";
    }
    
    static float getDiscountPercentage(int before, int after) {
        float discount;
        if(before>after){
            discount = (float)after/(float)before;
            //System.out.println("here " + after +"test " + before);
            discount = discount*100;
            //System.out.println("here2 "+discount);
        }else{
            //System.out.println("nope");
            discount = 0;
        }
        //System.out.println("I just got executed!");
        return discount;
    }

    static int getDiscountedPrice(int price, float discountPercentage) {
        float floatPrice;
        int finalPrice;
        
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }
        
        floatPrice = (float)price ;
        floatPrice = discountPercentage/(100.0f * floatPrice);
        finalPrice = (int)floatPrice;
        return finalPrice;
        //System.out.println("I just got executed!");
    }

    static void getOriginalPrice() {
        //System.out.println("I just got executed!");
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
