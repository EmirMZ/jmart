package EmirMuhamadZaidJmartAK;


/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Product
{
    public String name;
    public int weight ;
    public boolean conditionUsed;
    public PriceTag priceTag;
    public ProductCategory category;
    public ProductRating rating;
    public int storeid;
    
    Product(String name, int weight, boolean conditionUsed,PriceTag priceTag, ProductCategory category, ProductRating rating, int id){
        this.name = name  ;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = rating;
        this.storeid = id;
    }
    
    
    
}
