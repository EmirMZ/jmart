package EmirMuhamadZaidJmartAK;



public abstract class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public static Rating rating;
    public static Status status;
    
    protected Invoice (int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.rating = Rating.NONE;
        this.date = "tolong";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }

    @Override
    public boolean read (String content){
        return false;
    }
}
