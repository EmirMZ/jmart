package com.EmirMuhamadZaidJmartAK;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;


/**
 * Coupon class for individual coupon objects
 */
public class Coupon extends Serializable
{
    private static boolean used;
    public final int code;
    public final double cut;
    public static double minimum;
    public final String name;
    public final Type type;

    /**
     * Coupon constructor
     * @param name
     * @param code
     * @param type
     * @param cut
     * @param minimum
     */
    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        Coupon.minimum = minimum;
        used = false;
    }

    /**
     * apply a coupon to a product, returns the discounted product
     * @param price
     * @param discount
     * @return
     */
    public double apply(double price, double discount)
    {
        used = true;
        double adjustedPrice = Treasury.getAdjustedPrice(price, discount);
        switch (type)
        {
            case REBATE:
                if (adjustedPrice <= cut) return 0.0;
                return adjustedPrice - cut;
            case DISCOUNT:
                if (cut >= 100.0) return 0.0;
                return adjustedPrice - adjustedPrice * (cut / 100);
        }
        return 0.0;
    }

    /**
     * check if coupon is valid and not below the minimum threshold
     * @param price
     * @param discount
     * @return
     */
    public boolean canApply(double price, double discount)
    {
        return !used && !(Treasury.getAdjustedPrice(price, discount) < minimum);
    }

    /**
     * return used status
     * @return
     */
    public boolean isUsed(){
        return this.used;
    }

    public static enum Type{
        DISCOUNT,
        REBATE
    }
}
