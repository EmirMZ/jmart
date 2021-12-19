package com.EmirMuhamadZaidJmartAK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Payment class for every payment object
 */
public class Payment extends Invoice /*implements Transactor*/
{
    public List<Record> history = new ArrayList<Record>();
    public int productCount;
    public Shipment shipment;

    /**
     * Payment constructor
     * @param buyerId
     * @param productId
     * @param productCount
     * @param shipment
     */
    public Payment( int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId,productId);
        //this.buyerId = buyerId;
       // this.id =productId;
        this.productCount =productCount;
        this.shipment = shipment;
        //this.productId = productId;

    }

    /**
     * Record class
     */
    public static class Record {
        public Status status;
        public Date date;
        public String message;

        /**
         * Record constructor
         * @param status
         * @param message
         */
        public Record(Status status, String message) {
            this.status = status;
            this.message = message;
            this.date = java.util.Calendar.getInstance().getTime();
        }
    }

    /**
     * get total pay of a certain purchase
     * @param product
     * @return
     */
    public double getTotalPay(Product product){
        return (product.price*this.productCount)*(product.discount/100);
    }
/*
    @Override
    public boolean validate() {return false;}
    public Invoice perform() {return null;}
    public double getTotalPay() {return 0.0;}
*/
}
