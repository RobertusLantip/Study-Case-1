package com.mitrais.view;

import com.mitrais.model.Account;
import com.mitrais.Storage;
import com.mitrais.model.TransactionHistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Summary {
    public void summary(Account user, int choice){
        Scanner input = new Scanner(System.in);
        String choose = "2";
        MainMenu mm = new MainMenu();
        WelcomeScreen ws = new WelcomeScreen();
        Withdraw w = new Withdraw();
        Summary s = new Summary();
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String formatDateTime = datetime.format(formatter);
        switch (choice){
            case 1:
                user.setBalance(user.getBalance()-10);
                Storage.data.set(Storage.getIndex(user.getAccountnumber()),user);
                Storage.historyList().add(new TransactionHistory("Withdraw",0,formatDateTime,10));
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $10");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if("1".equals(choose)){
                    mm.mainMenu(user);
                }else if("2".equals(choose)){
                    ws.welcomeScreen();
                }else{
                    ws.welcomeScreen();
                }
                break;
            case 2:
                user.setBalance(user.getBalance()-50);
                Storage.data.set(Storage.getIndex(user.getAccountnumber()),user);
                Storage.historyList().add(new TransactionHistory("Withdraw",0,formatDateTime,50));
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $50");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if("1".equals(choose)){
                    mm.mainMenu(user);
                }else if("2".equals(choose)){
                    ws.welcomeScreen();
                }else{
                    ws.welcomeScreen();
                }
                break;
            case 3:
                user.setBalance(user.getBalance()-100);
                Storage.data.set(Storage.getIndex(user.getAccountnumber()),user);
                Storage.historyList().add(new TransactionHistory("Withdraw",0,formatDateTime,100));
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $100");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if("1".equals(choose)){
                    mm.mainMenu(user);
                }else if("2".equals(choose)){
                    ws.welcomeScreen();
                }else{
                    ws.welcomeScreen();
                }
                break;
            case 4:
                System.out.println("----=======SUMMARY=======----");
                System.out.print("Enter amount to withdraw : ");
                String value = input.next();
                if(!value.matches("[0-9]+") && Double.parseDouble(value)%10 != 0){
                    System.out.print("\nInvalid ammount");
                    s.summary(user,choice);
                }else if(Double.parseDouble(value) >1000){
                    System.out.print("\nMaximum amount to withdraw is $1000");
                    s.summary(user,choice);
                }else if(user.getBalance()<Double.parseDouble(value)){
                    System.out.print("\nInsufficient balance $"+value);
                    w.withdraw(user);
                }
                user.setBalance(user.getBalance()-Double.parseDouble(value));
                Storage.data.set(Storage.getIndex(user.getAccountnumber()),user);
                Storage.historyList().add(new TransactionHistory("Withdraw",0,formatDateTime,Double.parseDouble(value)));
                System.out.println("\nDate : "+formatDateTime);
                System.out.println("Withdraw : $"+value);
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if("1".equals(choose)){
                    mm.mainMenu(user);
                }else if("2".equals(choose)){
                    ws.welcomeScreen();
                }else{
                    ws.welcomeScreen();
                }
                break;
        }
    }
}
