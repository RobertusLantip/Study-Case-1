package com.mitrais;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main{

    List<Account> data = Storage.persons();
    public static void main(String[] args) {
        Main main = new Main();
        main.welcomeScreen();
    }

    public void welcomeScreen(){
        Scanner input = new Scanner(System.in);
        Account user;
        String accnumber,pin;
        System.out.println("----=======WELCOME=======----");
        System.out.println("Please insert your pin and account number");
        System.out.print("Enter Account Number : ");
        accnumber = input.next();
        System.out.print("\nEnter PIN : ");
        pin = input.next();
        if(accnumber.length()!=6){
            System.out.println("Account Number should have 6 digits length");
        }else if(accnumber.contains("[a-zA-Z]+"))
        {
            System.out.println("Account Number should only contains numbers");
        }else if(pin.length()!=6){
            System.out.println("PIN should have 6 digits length");
        }else if(pin.contains("[a-zA-Z]+")){
            System.out.println("PIN should only contains numbers");
        }else{

            if(Validation.validation(Integer.parseInt(accnumber),pin) != null){
                user = data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
                mainMenu(user);
            }else{
                System.out.println("Invalid Account Number/PIN");
                welcomeScreen();
            }
        }
    }

    public void mainMenu(Account user) {
        String menu = "3";
        Scanner input = new Scanner(System.in);
        System.out.println("----=======MENU=======----");
        System.out.println("1. withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.print("Please Choose Option[3] : ");
        menu = input.nextLine();
        switch (menu) {
            case "1":
                withdraw(user);
                break;
                case "2":
                    fundTransfer1(user);
                    break;
            case "3": welcomeScreen();
            }
    }

    public void withdraw(Account user){
        Scanner input = new Scanner(System.in);
        String menu = "5";
        System.out.println("----=======WITHDRAW=======----");
        System.out.println("1. $10");
        System.out.println("2. $50");
        System.out.println("3. $100");
        System.out.println("4. Other");
        System.out.println("5. Back");
        System.out.print("Please Choose Option[5] : ");
        menu = input.nextLine();
        switch (menu){
            case "1":
                summary(user,1);
                break;
            case "2":
                summary(user,2);
                break;
            case "3":
                summary(user,3);
                break;
            case "4":
                summary(user,4);
                break;
            case "5":
                mainMenu(user);
        }
    }


    public void summary(Account user,int choice){
        Scanner input = new Scanner(System.in);
        String choose = "2";
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
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if(choose == "1"){
                    mainMenu(user);
                }else if(choose == "2"){
                    welcomeScreen();
                }
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
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if(choose == "1"){
                    mainMenu(user);
                }else if(choose == "2"){
                    welcomeScreen();
                }
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
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if(choose == "1"){
                    mainMenu(user);
                }else if(choose == "2"){
                    welcomeScreen();
                }
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
                System.out.print("Choose Option[2] : "); choose = input.nextLine();
                if(choose == "1"){
                    mainMenu(user);
                }else if(choose == "2"){
                    welcomeScreen();
                }
                break;
        }
    }

    public void fundTransfer1(Account user){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter destination account and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        int accnumber = input.nextInt();
        fundTransfer2(user,accnumber);
    }

    public void fundTransfer2(Account user,int accnumber){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter transfer amount and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        int amount = input.nextInt();
        fundTransfer3(user,accnumber,amount);
    }

    public void fundTransfer3(Account user,int accnumber, int amount){
        Scanner input = new Scanner(System.in);
        int refnumber = 0;
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter reference number (Optional) and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        refnumber = input.nextInt();
        fundTransfer4(user,accnumber,amount,refnumber);
    }

    public void fundTransfer4(Account user,int accnumber,int amount, int refnumber){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Transfer Confirmation");
        System.out.println("Destination Account \t: "+accnumber);
        System.out.println("Transfer Amount \t\t: $"+amount);
        System.out.println("Reference Number \t\t: "+refnumber);
        System.out.println("1. Confirm Trx\n" +
                "2. Cancel Trx\n" +
                "Choose option[2]: ");
        int choose = input.nextInt();
        switch (choose){
            case 1:
                Account target = data.stream().filter(x -> accnumber == x.getAccountnumber()).findAny().orElse(null);
                target.setBalance(target.getBalance() + amount);
                data.set(Storage.getIndex(accnumber),target);

                user.setBalance(user.getBalance() - amount);
                data.set(Storage.getIndex(user.getAccountnumber()),user);

                System.out.println("----=======FUND TRANSFER SUMMARY=======----");
                System.out.println("Destination Account \t: "+accnumber);
                System.out.println("Transfer Amount \t\t: $"+amount);
                System.out.println("Reference Number \t\t: "+refnumber);
                System.out.println("Balance \t\t: "+user.getBalance());
                System.out.println("1. Confirm Trx\n" +
                        "2. Cancel Trx\n" +
                        "Choose option[2]: ");
                choose = input.nextInt();
                break;
        }
    }
}