package EmirMuhamadZaidJmartAK;

public class Product extends Recognizable implements FileParser 
{
    public String content;
    public String name;
    public int weight ;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeid;
    public Shipment.MultiDuration multiDuration;
    
    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, PriceTag priceTag, ProductCategory category, Shipment.MultiDuration multiDuration){
        super(id);
        this.name = name  ;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = rating;
        this.storeid = id;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
    
    public String toString(){
        return this.name + this.weight + this.conditionUsed + this.priceTag + this.category + this.rating + this.storeid;
    }
}
