package com.mitrais.view;

import com.mitrais.model.Account;
import com.mitrais.Storage;
import com.mitrais.model.TransactionHistory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FundTransfer {
    MainMenu mm = new MainMenu();
    WelcomeScreen ws = new WelcomeScreen();
    public void fundTransfer1(Account user){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter destination account and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        String accnumber = input.next();
        if(!accnumber.matches("[0-9]+")){
            System.out.println("\nInvalid account");
            fundTransfer1(user);
        }else {
            Account target = Storage.data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
            if(target == null){
                System.out.println("\nInvalid account");
                fundTransfer1(user);
            }else{
                fundTransfer2(user,accnumber);
            }
        }
    }

    public void fundTransfer2(Account user,String accnumber){
        Scanner input = new Scanner(System.in);
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter transfer amount and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        String amount = input.next();
        if(!amount.matches("[0.0-9]+")){
            System.out.println("\nInvalid amount");
            fundTransfer2(user,accnumber);
        }else if(Double.parseDouble(amount) < 1){
            System.out.println("\nMinimum amount to withdraw is $1");
            fundTransfer2(user,accnumber);
        }else if(Double.parseDouble(amount) > 1000){
            System.out.println("\nMaximum amount to withdraw is $1000");
            fundTransfer2(user,accnumber);
        }else if(user.getBalance()<Double.parseDouble(amount)){
            System.out.println("\nInsufficient balance $"+amount);
            fundTransfer2(user,accnumber);
        }
        else{
            fundTransfer3(user,accnumber,amount);
        }
    }

    public void fundTransfer3(Account user,String accnumber, String amount){
        Scanner input = new Scanner(System.in);
        String refnumber;
        System.out.println("----=======FUND TRANSFER=======----");
        System.out.println("Please enter reference number (Optional) and \n" +
                "press enter to continue or \n" +
                "press cancel (Esc) to go back to Transaction: ");
        refnumber = input.next();
        if(!refnumber.matches("[0-9]+")){
            System.out.println("\nInvalid Reference Number");
            fundTransfer3(user,accnumber,amount);
        }else{
            fundTransfer4(user,accnumber,amount,refnumber);
        }
    }

    public void fundTransfer4(Account user,String accnumber,String amount, String refnumber){
        LocalDateTime datetime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
        String formatDateTime = datetime.format(formatter);

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
                Account target = Storage.data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
                target.setBalance(target.getBalance() + Double.parseDouble(amount));
                Storage.data.set(Storage.getIndex(Integer.parseInt(accnumber)),target);

                user.setBalance(user.getBalance() - Double.parseDouble(amount));
                Storage.data.set(Storage.getIndex(user.getAccountnumber()),user);
                Storage.transactionHistories.add(new TransactionHistory("Fund Transfer",Integer.parseInt(accnumber),formatDateTime,Double.parseDouble(amount)));

                System.out.println("----=======FUND TRANSFER SUMMARY=======----");
                System.out.println("Destination Account \t: "+accnumber);
                System.out.println("Transfer Amount \t\t: $"+amount);
                System.out.println("Reference Number \t\t: "+refnumber);
                System.out.println("Balance \t\t: "+user.getBalance());
                System.out.println("1. Transaction\n" +
                        "2. Exit\n" +
                        "Choose option[2]: ");
                choose = input.nextInt();
                if(choose == 1){
                    mm.mainMenu(user);
                }else{
                    ws.welcomeScreen();
                }
                break;
            case 2:
                mm.mainMenu(user);
                break;
            default: mm.mainMenu(user);
        }
    }
}