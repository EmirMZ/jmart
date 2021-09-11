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
        
        System.out.println("getDiscountPercentage(1000,900) = " + getDiscountPercentage(1000,900));
        System.out.println("getDiscountPercentage(1000,0) = " + getDiscountPercentage(1000,0));
        System.out.println("getDiscountPercentage(0,0) = " + getDiscountPercentage(0,0));
        System.out.println("getDiscountPercentage(0,1) = " + getDiscountPercentage(0,1));
        
        System.out.println("getDiscountedPrice(1000,10.0f) = " + getDiscountedPrice(1000,10.0f));
        System.out.println("getDiscountedPrice(1000,100.0f) = " + getDiscountedPrice(1000,100.0f));
        System.out.println("getDiscountedPrice(1000,120.0f) = " + getDiscountedPrice(1000,120.0f));
        System.out.println("getDiscountedPrice(0,0.0f) = " + getDiscountedPrice(0,0.0f));
        
        System.out.println("getOriginalPrice(900,10.0f) = " + getOriginalPrice(900,10.0f));
        System.out.println("getOriginalPrice(1000,0.0f) = " + getOriginalPrice(1000,0.0f));
        System.out.println("getOriginalPrice(0,100.0f) = " + getOriginalPrice(0,100.0f));
        System.out.println("getOriginalPrice(0,120.0f) = " + getOriginalPrice(0,120.0f));
        
        System.out.println("getCommissionMultiplier() = " + getCommissionMultiplier());
        
        System.out.println("getAdjustedPrice(1000) = " +  getAdjustedPrice(1000));
        System.out.println("getAdjustedPrice(500) = " +  getAdjustedPrice(500));
        System.out.println("getAdjustedPrice(0) = " +  getAdjustedPrice(0));
        
        System.out.println("getAdminFee(1000) = " + getAdminFee(1000));
        System.out.println("getAdminFee(500) = " + getAdminFee(500));
        System.out.println("getAdminFee(0) = " + getAdminFee(0));
        
        System.out.println(getPromo());
    }
    
    static int getPromo() {
       
        return 0;
    }
   
    static String getCustomer() {
        

        return "oop";
    }
    
    static float getDiscountPercentage(int before, int after) {
        float discount;
        if(before>after){
            discount = (float)(((float)(before)-(float)after)/(float)before);
           
            discount = discount*100;

        }else{

            discount = 0;
            
        }
        return discount;
    }

    static int getDiscountedPrice(int price, float discountPercentage) {
        float floatPrice;
        int finalPrice;
        
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }

        return (int)((float)(price)-((float)price)*((float)discountPercentage/100.0f));
     }

    static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }
        return (int)((float)(discountedPrice * 100.0f)/(100.0f-(float)discountPercentage));
        //System.out.println("I just got executed!");
    }
     
    static float getCommissionMultiplier() {
        return 0.05f;
    }
    
    static int getAdjustedPrice(int price) {
        price = (int)((float)(getCommissionMultiplier() * price) + (float)price);
        //System.out.println("I just got executed!");
        return price;
    }

    static int getAdminFee(int price) {
        //System.out.println("I just got executed!");
        price = (int)((float)(getCommissionMultiplier() * price));
        return price;
    }
}
