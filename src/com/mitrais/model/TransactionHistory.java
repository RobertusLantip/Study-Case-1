package com.mitrais.model;

public class TransactionHistory {
    private int accountnumber;
    private String type, date;
    private double amount;

    public TransactionHistory(String type, int accountnumber, String date, double amount) {
        this.type = type;
        this.accountnumber = accountnumber;
        this.date = date;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(int accountnumber) {
        this.accountnumber = accountnumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
