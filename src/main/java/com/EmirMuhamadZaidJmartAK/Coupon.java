package com.EmirMuhamadZaidJmartAK;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

public class Coupon extends Serializable
{
    private static boolean used;
    public final int code;
    public final double cut;
    public static double minimum;
    public final String name;
    public final Type type;

    public Coupon(String name, int code, Type type, double cut, double minimum){
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        Coupon.minimum = minimum;
        used = false;
    }

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

    public boolean canApply(double price, double discount)
    {
        return !used && !(Treasury.getAdjustedPrice(price, discount) < minimum);
    }

    public boolean isUsed(){
        return this.used;
    }

    public static enum Type{
        DISCOUNT,
        REBATE
    }
}
