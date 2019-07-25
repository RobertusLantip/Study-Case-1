package com.mitrais;

import com.mitrais.model.Account;

public class Validation {
    public static Account validation(int accnumber, String pin){
        Account account = Storage.persons().stream()
                .filter(x -> accnumber == x.getAccountnumber())
                .filter(x -> pin.equals(x.getPin()))
                .findAny().orElse(null);
        return account;
    }
}