package com.EmirMuhamadZaidJmartAK;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

public class Store extends Serializable //implements FileParser
{
    public static final String REGEX_PHONE = "^(\\d{9,12})$";
    public static final String REGEX_NAME = "^(^([A-Za-z]{4,20}).([A-Za-z]{0,20})$)$";
    public String name;
    public String address;
    public String phoneNumber;
    
    Store(int id, String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    Store(Account account, String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
   // @Override
   // public boolean read (String content){
   //     return false;
    //}

    public String toString() {
        return "name :" + this.name + "address :" + this.address +  "phone number :" + this.phoneNumber;
    }
    
    public boolean validate(String name,String phoneNumber){
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phoneNumber);
        boolean matchFound = matcher.find();
        
        pattern = pattern.compile(REGEX_NAME);
        matcher = pattern.matcher(name);
        boolean matchFoundTwo = matcher.find();
        
        return matchFound&&matchFoundTwo;
        
    }
    
}
