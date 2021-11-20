package com.EmirMuhamadZaidJmartAK;
import java.util.ArrayList;

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
