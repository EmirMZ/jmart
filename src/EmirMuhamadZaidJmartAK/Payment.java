package EmirMuhamadZaidJmartAK;


public class Payment extends Invoice implements Transactor
{
    public int productCount;
    public Shipment shipment;
    

    public Payment(int id, int buyerId, int productId, int productCount, Shipment shipment){
        super(id,buyerId,productId);
        this.shipment = shipment;
    }

    @Override
    public boolean validate() {return false;}
    public Invoice perform() {return null;}
    public double getTotalPay() {return 0.0;}
}