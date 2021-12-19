package com.EmirMuhamadZaidJmartAK;
import java.util.ArrayList;

/**
 * Filter class, probably deprecated for other function
 */
public class Filter
{
    public static ArrayList<PriceTag> filterPriceTag(PriceTag[] list,double value,boolean less){
        ArrayList<PriceTag> priceTags = new ArrayList<>();
        for(PriceTag a : list){
            if (less && a.getAdjustedPrice() < value){
                priceTags.add(a);
            }
        }
        return priceTags;
        
    }
}
