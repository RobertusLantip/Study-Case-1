package com.mitrais;

import java.math.BigDecimal;

public class Account {
    private String name;
    private double balance;
    private int accountnumber;
    private long pin;

    public Account(String name, double balance, long pin, int accountnumber) {
        this.name = name;
        this.balance = balance;
        this.pin = pin;
        this.accountnumber = accountnumber;
    }

    public Account(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getPin() {
        return pin;
    }

    public void setPin(long pin) {
        this.pin = pin;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }
}
