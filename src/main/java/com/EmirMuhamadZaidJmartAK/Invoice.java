package com.EmirMuhamadZaidJmartAK;

import java.util.Date;
import java.util.ArrayList;


public abstract class Invoice extends Serializable //implements FileParser
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public static Rating rating;
    public static Status status;
    //public ArrayList<Record> history = new ArrayList<Record>();

    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRES,
        ON_DELIVERY,
        COMPLAYINT,
        FINISHED,
        FAILED
    }

    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }


    protected Invoice (int buyerId,  int productId){
        //super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.complaintId = -1;
        //this.rating = Rating.NONE;
        this.date = new Date();
        //this.rating = Rating.NONE;
        //System.out.println(date.toString());
        status = Status.WAITING_CONFIRMATION;
    }

    public abstract double getTotalPay(Product product);

    public boolean read(String content) {
        return false;
    }
    
    public class Record {
        public Status status;
        public Date date;
        public String message;
    }
    
   // @Override
    //public boolean read (String content){
      //  return false;
    //}
}
