package EmirMuhamadZaidJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author Emir Muhamad Zaid
 * @version (a version number or a date)
 */


public class Jmart
{
    public static void main(String[] args) {
    }
    
    public static int getPromo() {
       
        return 0;
    }
   
    public static String getCustomer() {
        

        return "oop";
    }
    
    public static float getDiscountPercentage(int before, int after) {
        float discount;
        if(before>after){
            discount = (float)(((float)(before)-(float)after)/(float)before);
           
            discount = discount*100;

        }else{

            discount = 0;
            
        }
        return discount;
    }

    public static int getDiscountedPrice(int price, float discountPercentage) {
        float floatPrice;
        int finalPrice;
        
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }

        return (int)((float)(price)-((float)price)*((float)discountPercentage/100.0f));
     }

    public static int getOriginalPrice(int discountedPrice, float discountPercentage) {
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }
        return (int)((float)(discountedPrice * 100.0f)/(100.0f-(float)discountPercentage));
    }
     
    public static float getCommissionMultiplier() {
        return 0.05f;
    }
    
    public static int getAdjustedPrice(int price) {
        price = (int)((float)(getCommissionMultiplier() * price) + (float)price);
        return price;
    }

    public static int getAdminFee(int price) {
        price = (int)((float)(getCommissionMultiplier() * price));
        return price;
    }
}
