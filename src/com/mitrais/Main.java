package com.mitrais;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    List<Account> data = Storage.persons();
    public static void main(String[] args) {
        Account user = new Account();
        Scanner input = new Scanner(System.in);
        Main main = new Main();
        System.out.println("----=======WELCOME=======----");
        System.out.println("Please insert your pin and account number");
        System.out.print("Enter Account Number : ");
        user.setAccountnumber(input.nextInt());
        System.out.print("\nEnter PIN : ");
        user.setPin(input.nextLong());

        if(Validation.validation(user.getAccountnumber(),user.getPin()) != null){
            user = Validation.validation(user.getAccountnumber(),user.getPin());
            main.mainMenu(user);
        }else{
            System.out.println("Gagal Login");
        }
    }

    public void mainMenu(Account user){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======MENU=======----");
        System.out.println("1. withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.print("Please Choose Option[3] : ");
        int menu = input.nextInt();
        switch (menu){
            case 1:
                withdraw(user);
                break;
            case 2:
                break;
            case 3:
        }
    }

    public void withdraw(Account user){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======WITHDRAW=======----");
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please Choose Option[5] : ");
        int menu = input.nextInt();
        switch (menu){
            case 1:
                summary(user,1);
                break;
            case 2:
                summary(user,2);
                break;
            case 3:
                summary(user,3);
                break;
            case 4:
                summary(user,4);
                break;
            case 5:

        }
    }

    public void summary(Account user,int choice){
        Scanner input = new Scanner(System.in);
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String formatDateTime = datetime.format(formatter);
        switch (choice){
            case 1:
                user.setBalance(user.getBalance()-10);
                data.set(Storage.getIndex(user.getAccountnumber()),user);
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $10");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.println("Choose Option[2] : ");
                break;
            case 2:
                user.setBalance(user.getBalance()-50);
                data.set(Storage.getIndex(user.getAccountnumber()),user);
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $50");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.println("Choose Option[2] : ");
                break;
            case 3:
                user.setBalance(user.getBalance()-100);
                data.set(Storage.getIndex(user.getAccountnumber()),user);
                System.out.println("----=======SUMMARY=======----");
                System.out.println("Date : "+formatDateTime);
                System.out.println("Withdraw : $100");
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.println("Choose Option[2] : ");
                break;
            case 4:
                System.out.println("----=======SUMMARY=======----");
                System.out.print("Enter amount to withdraw : ");
                int value = input.nextInt();
                user.setBalance(user.getBalance()-value);
                data.set(Storage.getIndex(user.getAccountnumber()),user);
                System.out.println("\nDate : "+formatDateTime);
                System.out.println("Withdraw : $"+value);
                System.out.println("Balance : $"+user.getBalance());
                System.out.println("\n1. Transaction");
                System.out.println("2. Exit");
                System.out.println("Choose Option[2] : ");
                break;
        }
    }
}