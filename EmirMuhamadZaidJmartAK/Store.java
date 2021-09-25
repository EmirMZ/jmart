package EmirMuhamadZaidJmartAK;



public class Store extends Recognizable implements FileParser
{
    public String name;
    public String address;
    public String phoneNumber;
    
    Store(int id, String name, String address, String phoneNumber){
        super(id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    Store(Account account, String name, String address, String phoneNumber){
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public boolean read (String content){
        return false;
    }
}
