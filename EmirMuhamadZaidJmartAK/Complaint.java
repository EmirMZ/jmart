package EmirMuhamadZaidJmartAK;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable implements FileParser
{
    public Calendar date;
    public String desc;
    
    public Complaint (int id, String desc){
        super(id);
        this.desc =desc;
    }
    
    
    @Override
    public boolean read(String content){
        return false;
    }
}
  