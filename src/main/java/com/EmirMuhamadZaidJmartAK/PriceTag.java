package com.EmirMuhamadZaidJmartAK;


/**
 * Pricetag class, for Handling prices
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

    /**
     * get price
     * @param price
     */
    public PriceTag(double price){
         this.price = price;
         this.discount = 0.0;
     }

    /**
     * get price with discount
     * @param price
     * @param discount
     */
     public PriceTag(double price, double discount){
         this.price = price;
         this.discount = discount;
     }

    /**
     * get adjusted price after discount
     * @return
     */
     public double getAdjustedPrice(){
         return getDiscountedPrice(this.price,this.discount ) - getAdminFee();
     }

    /**
     * return admin fee based on price
     * @return
     */
    public double getAdminFee(){
         double finalFee;
         
         if (this.price > this.BOTTOM_PRICE){
             finalFee =this.BOTTOM_FEE;
         }else{
             finalFee = (this.COMMISSION_MULTIPLIER * this.price);
         }
         return finalFee;
        }

    /**
     * get discounted price
     * @param price
     * @param discountPercentage
     * @return
     */
     private double getDiscountedPrice(double price, double discountPercentage) {
        
        if (discountPercentage > 100.0f){
            discountPercentage = 100.0f;
        }

        return ((price)-(price)*(discountPercentage/100.0f));
     }
}