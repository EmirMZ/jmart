package com.EmirMuhamadZaidJmartAK;

import java.util.Date;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

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
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }


    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
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
