package com.EmirMuhamadZaidJmartAK;


/**
 * File parser interface
 *w
 * @author (your name)
 * @version (a version number or a date)
 */
public interface FileParser
{
    
    public boolean read (String content);
    public default Object write(){
        return null;
    };
    public static Object newInstance(String content){
        return null;
    }
}
