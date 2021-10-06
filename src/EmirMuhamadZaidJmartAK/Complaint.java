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
    
    public String toString(){
        SimpleDateFormat SDtemplate = new SimpleDateFormat("dd/MM/yyyy");
        
        String tanggal = SDtemplate.format(this.date);
        
        return "{date = " + tanggal + "desc = '" + this.desc + "'}"; 
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
  