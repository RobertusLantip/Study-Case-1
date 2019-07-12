package com.mitrais;

public class Validation {
    public static Account validation(int accnumber,long pin){
        Account account = Storage.persons().stream()
                .filter(x -> accnumber == x.getAccountnumber())
                .filter(x -> pin == x.getPin())
                .findAny().orElse(null);
        return account;
    }
}