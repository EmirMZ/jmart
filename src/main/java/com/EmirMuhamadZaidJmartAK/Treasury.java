package com.EmirMuhamadZaidJmartAK;

public class Treasury {
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double price, discount;

    public static double getAdjustedPrice(double price, double discount){
        return getDiscountedPrice(price, discount) + getAdminFee(price, discount);
    }

    private static double getDiscountedPrice(double price, double discount){
        if (discount >= 100){
            return 0.0;
        }else{
            return ((100.0 - discount) * price) / 100;
        }
    }

    public static double getAdminFee(double price, double discount){
        if (getDiscountedPrice(price, discount) < BOTTOM_PRICE){
            return BOTTOM_FEE;
        }else{
            return getDiscountedPrice(price, discount) - (price * COMMISSION_MULTIPLIER);
        }
    }
}
