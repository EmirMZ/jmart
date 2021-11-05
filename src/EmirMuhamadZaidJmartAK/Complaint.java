package EmirMuhamadZaidJmartAK;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Complaint extends Recognizable //implements FileParser
{
    public Date date;
    public String desc;
    
    public Complaint (String desc){
        this.desc = desc;
        this.date = new Date();

    }
    
    public String toString(){
        SimpleDateFormat SDtemplate = new SimpleDateFormat("dd/MM/yyyy");
        
        String tanggal = SDtemplate.format(this.date);
        
        return "{date = " + tanggal + "desc = '" + this.desc + "'}"; 
    }
    
    //@Override
    //public boolean read(String content){
    //    return false;
    //}
}
  