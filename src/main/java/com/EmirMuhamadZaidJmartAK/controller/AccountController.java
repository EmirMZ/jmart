package com.EmirMuhamadZaidJmartAK.controller;

import com.EmirMuhamadZaidJmartAK.Account;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonAutowired;
import com.EmirMuhamadZaidJmartAK.dbjson.JsonTable;
import com.EmirMuhamadZaidJmartAK.Store;
import com.EmirMuhamadZaidJmartAK.dbjson.Serializable;

import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>{
    public static final String REGEX_EMAIL = "^\\w+([\\.&`~-]?\\w+)*@\\w+([\\.-]?\\w+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{7,}$";
    public static final Pattern REGEX_PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    public static final Pattern REGEX_PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);
    @JsonAutowired(value = Account.class,filepath = "akun.json")
    public static JsonTable<Account> accountTable;

    @PostMapping("/login")
    Account login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        for (Account data : accountTable){

            if(data.email.equals(email) && data.password.equals(password)){
                return data;
            }
        }
        return null;
    }

    @PostMapping("/register")
    Account register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {

        boolean hasilEmail = REGEX_PATTERN_EMAIL.matcher(email).find();
        boolean hasilPassword = REGEX_PATTERN_PASSWORD.matcher(password).find();
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
            }
            password = sb.toString();
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        if(!name.isBlank() && hasilEmail && hasilPassword && !accountTable.stream().anyMatch(account -> account.email.equals(email))){
            Account account =  new Account(name, email, password, 0);
            accountTable.add(account);
            return account;
        }
        return null;
    }
    @PostMapping("/{id}/registerStore")
    Store register
            (
                    @RequestParam int id,
                    @RequestParam String name,
                    @RequestParam String address,
                    @RequestParam String phoneNumber
            )
    {
        for(Account data : accountTable){
            if (data.store == null && data.id == id){
                data.store = new Store(name,address,phoneNumber,0);
                return data.store;
            }
        }
        return null;
    }

    @PostMapping("/{id}/topUp")
    boolean topUp
            (
                    @RequestParam int id,
                    @RequestParam double balance
            )
    {
        BigDecimal bd = new BigDecimal(String.valueOf(balance));
        BigDecimal roundedBalance = bd.setScale(3, RoundingMode.FLOOR);

        for(Account data : accountTable){
            if(data.id == id) {
                data.balance += roundedBalance.doubleValue();
                return true;
            }
        }
        return false;
    }

    @PostMapping("/{id}/checkbalance")
    double checkBalance
            (
                    @RequestParam int id
            )
    {


        for(Account data : accountTable){
            if(data.id == id) {
                return data.balance;
            }
        }
        return -100;
    }

    @Override
    @GetMapping("/{id}")
    public Account getById(@PathVariable int id) {
        return BasicGetController.super.getById(id);
    }

    @Override
    public JsonTable getJsonTable() {
        return accountTable;
    }

    @Override
    public List getPage(int page, int pageSize) {
        return BasicGetController.super.getPage(page, pageSize);
    }
}