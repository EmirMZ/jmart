package EmirMuhamadZaidJmartAK;


/**
 * Write a description of class Jmart here.
 *
 * @author Emir Muhamad Zaid
 * @version (a version number or a date)
 */

// + = public
// - = private
// _ = static

public class PriceTag{
     public static double COMMISSION_MULTIPLIER = 0.05;
     public static double BOTTOM_PRICE =  20000.0;
     public static double BOTTOM_FEE = 1000.0;
     
     public double discount;
     public double price;
     
     public PriceTag(double price){
         this.price = price;
         this.discount = 0.0;
     }
     
     public PriceTag(double price, double discount){
         this.price = price;
         this.discount = discount;
     }
 
     public double getAdjustedPrice(){
         return getDiscountedPrice(this.price,this.discount ) - getAdminFee();
     }
     
     public double getAdminFee(){
         double finalFee;
         
         if (this.price > this.BOTTOM_PRICE){
             finalFee =this.BOTTOM_FEE;
         }else{
             finalFee = (this.COMMISSION_MULTIPLIER * this.price);
         }
         return finalFee;
        }
        
     
     private double getDiscountedPrice(double price, double discountPercentage) {
        
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }

        return ((price)-(price)*(discountPercentage/100.0f));
     }
}