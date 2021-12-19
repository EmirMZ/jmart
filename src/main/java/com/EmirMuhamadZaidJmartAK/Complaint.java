package com.EmirMuhamadZaidJmartAK;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

/**
 * Class Complaint for submitting complaint, and adding the date from cistomer
 */
public class Complaint extends Serializable //implements FileParser
{
    public Date date;
    public String desc;

    /**
     * Complaint class constructor
     * @param desc
     */
    public Complaint (String desc){
        this.desc = desc;
        this.date = new Date();

    }

    /**
     * method to return the complaint format
     * @return
     */
    public String toString(){
        SimpleDateFormat SDtemplate = new SimpleDateFormat("dd/MM/yyyy");
        
        String tanggal = SDtemplate.format(this.date);
        
        return "{date = " + tanggal + "desc = '" + this.desc + "'}"; 
    }
    
    //@Override
    //public boolean read(String content){
    //    return false;
    //}
}
  