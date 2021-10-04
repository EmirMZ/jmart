package EmirMuhamadZaidJmartAK;

import java.util.Date;
import java.util.ArrayList;


public abstract class Invoice extends Recognizable implements FileParser
{
    public String date;
    public int buyerId;
    public int productId;
    public int complaintId;
    public static Rating rating;
    public static Status status;
    public ArrayList<Record> history = new ArrayList<Record>();
    
    
    protected Invoice (int id, int buyerId, int productId){
        super(id);
        this.buyerId = buyerId;
        this.productId = productId;
        this.rating = Rating.NONE;
        this.date = "tolong";
        this.rating = Rating.NONE;
        this.status = Status.WAITING_CONFIRMATION;
    }

    
    public class Record {
        public String message;
        public Status status;
        public Date date;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
}
