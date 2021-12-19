package com.EmirMuhamadZaidJmartAK;

import java.util.Date;

import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

import java.util.ArrayList;

/**
 * Invoice class for invoice needs
 */
public abstract class Invoice extends Serializable
{
    public Date date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public static Rating rating;
    public static Status status;
    //public ArrayList<Record> history = new ArrayList<Record>();

    /**
     * Enumeration for order status
     */
    public enum Status {
        WAITING_CONFIRMATION,
        CANCELLED,
        ON_PROGRESS,
        ON_DELIVERY,
        COMPLAINT,
        FINISHED,
        FAILED
    }

    /**
     * Enumeration for rating
     */
    public enum Rating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD
    }

    /**
     * Invoice constructor
     * @param buyerId
     * @param productId
     */
    protected Invoice(int buyerId, int productId) {
        this.buyerId = buyerId;
        this.productId = productId;
        date = java.util.Calendar.getInstance().getTime();
        this.complaintId = -1;
        this.rating = Rating.NONE;
    }

    /**
     * get total payment
     * @param product
     * @return
     */
    public abstract double getTotalPay(Product product);

    /**
     * read a string, not used
     * @param content
     * @return
     */
    public boolean read(String content) {
        return false;
    }

    /**
     * Record class, not used
     */
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
