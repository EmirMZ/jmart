package EmirMuhamadZaidJmartAK;

public class Product extends Recognizable //implements FileParser
{
    public int accountId;
    public String content;
    public String name;
    public double discount;
    public int weight ;
    public boolean conditionUsed;
    //public PriceTag priceTag;
    public double price;
    public ProductCategory category;
    //public ProductRating rating;
    //public int storeid;
    public byte shipmentPlans;
    //public Shipment.MultiDuration multiDuration;
    
    public Product(int accountId, /*int storeId,*/ String name, int weight, boolean conditionUsed, double price, double discount, ProductCategory category, byte shipmentPlans){

        //super(id);
        this.accountId = accountId;
        this.name = name  ;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.price = price;
        this.discount = discount;
        this.shipmentPlans = shipmentPlans;
        this.category = category;
        //this.rating = rating;
        //this.storeid = storeId;
    }
    
    /*@Override
    public boolean read (String content){
        return false;
    }
    */
    public String toString(){
        return this.accountId + this.name + this.weight + this.conditionUsed + this.price + this.category + this.shipmentPlans;
    }
}
