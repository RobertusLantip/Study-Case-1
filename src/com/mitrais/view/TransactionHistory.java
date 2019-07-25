package com.mitrais.view;

import com.mitrais.model.Account;
import com.mitrais.Storage;

public class TransactionHistory {
    MainMenu mm = new MainMenu();
    public void transactionHistory(Account user){
        try{
            for (int i = 0; i < Storage.transactionHistories.size(); i++) {
                if ("Withdraw".equals(Storage.transactionHistories.get(i).getType())) {
                    System.out.println("---==WITHDRAW==---");
                    System.out.println("Date : " + Storage.transactionHistories.get(i).getDate());
                    System.out.println("Amount : " + Storage.transactionHistories.get(i).getAmount());
                } else {
                    System.out.println("\n---==FUND TRANSFER==---");
                    System.out.println("Date : " + Storage.transactionHistories.get(i).getDate());
                    System.out.println("Amount : " + Storage.transactionHistories.get(i).getAmount());
                    System.out.println("To : " + Storage.transactionHistories.get(i).getAccountnumber());
                    int accnumber = Storage.transactionHistories.get(i).getAccountnumber();
                    Account target = Storage.data.stream().filter(x -> accnumber == x.getAccountnumber()).findAny().orElse(null);
                    System.out.println("Name : " + target.getName());
                }
            }
            mm.mainMenu(user);
        }catch (NullPointerException e){
            System.out.println("No transaction histories\n");
            mm.mainMenu(user);
        }
    }
}