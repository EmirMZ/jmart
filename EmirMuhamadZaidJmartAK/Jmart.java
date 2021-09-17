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
    }
     
    static float getCommissionMultiplier() {
        return 0.05f;
    }
    
    static int getAdjustedPrice(int price) {
        price = (int)((float)(getCommissionMultiplier() * price) + (float)price);
        return price;
    }

    static int getAdminFee(int price) {
        price = (int)((float)(getCommissionMultiplier() * price));
        return price;
    }
}
