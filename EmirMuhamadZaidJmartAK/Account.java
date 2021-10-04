package EmirMuhamadZaidJmartAK;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser
{
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public String name;
    public String email;
    public String password;
    
    public Account (int id,String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
   
    
        public boolean validate(String email,String password){
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        boolean matchFound = matcher.find();
        
        pattern = pattern.compile(REGEX_PASSWORD);
        matcher = pattern.matcher(password);
        boolean matchFoundTwo = matcher.find();
        
        return matchFound&&matchFoundTwo;
        
    }
    
    
    
    
    @Override
    public boolean read (String content){
        return false;
    }
}
