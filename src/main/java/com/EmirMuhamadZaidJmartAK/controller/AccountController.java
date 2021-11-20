package com.EmirMuhamadZaidJmartAK.controller;
import com.EmirMuhamadZaidJmartAK.Account;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonTable;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/account/login")
    @ResponseBody Account login(String email, String password) {
        for(Account each : accountTable){
            if(each.email == email && each.password == password){
                return each;
            }
        }
        return null;
    }




    @Override
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return getJsonTable().get(id);
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return null;
    }

    @Override
    @GetMapping("/page")
    public List<Account> getPage(int page, int pageSize) {
        return getJsonTable().subList(page, pageSize);
    }
    
    @PostMapping("/register")
    Account register
    (
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String password
    )
    {
    	if(name.isBlank() || REGEX_PATTERN_EMAIL.matcher(email).find() || REGEX_PATTERN_PASSWORD.matcher(password).find() || accountTable.stream().anyMatch(account -> account.email.equals(email))){
    		return null;
    	}else{
    		return new Account(name, email, password, 0);
    	}
    }
    
}