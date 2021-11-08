package EmirMuhamadZaidJmartAK;


public class Payment extends Invoice /*implements Transactor*/
{
    public int productCount;
    public Shipment shipment;
    

    public Payment( int buyerId, int productId, int productCount, Shipment shipment){
        super(buyerId,productId);
        //this.buyerId = buyerId;
       // this.id =productId;
        this.productCount =productCount;
        this.shipment = shipment;
        //this.productId = productId;

    }




    public double getTotalPay(){
        return 0.0;
    }
/*
    @Override
    public boolean validate() {return false;}
    public Invoice perform() {return null;}
    public double getTotalPay() {return 0.0;}
*/
}
