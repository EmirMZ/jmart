package EmirMuhamadZaidJmartAK;
import javafx.scene.Parent;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Complaint extends Recognizable implements FileParser
{
    public String date;
    public String desc;
    
    public Complaint (int id, String desc){
        super(id);
        this.desc =desc;
    }
    
    public boolean validate(){
        return false;
    }
    
    public Transactor perform(){
        return null;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
