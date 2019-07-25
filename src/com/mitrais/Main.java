package com.mitrais;

import com.mitrais.model.TransactionHistory;
import com.mitrais.view.WelcomeScreen;

import java.util.ArrayList;
import java.util.List;

public class Main{

    int thid=0;
    List<TransactionHistory> transactionHistories= new ArrayList<>();
    public static void main(String[] args) {
        if(!Storage.validationDuplicate(Storage.persons())){
            System.out.println("Duplicate Record");
        }else if(!Storage.validationAN(Storage.persons())){
            System.out.println("Duplicate Account Number");
        }
        else {
//            Main main = new Main();
//            main.welcomeScreen();
            WelcomeScreen ws = new WelcomeScreen();
            ws.welcomeScreen();
        }
    }

//    public void welcomeScreen(){
//        Scanner input = new Scanner(System.in);
//        Account user;
//        String accnumber,pin;
//        System.out.println("----=======WELCOME=======----");
//        System.out.println("Please insert your pin and account number");
//        System.out.print("Enter Account Number : ");
//        accnumber = input.next();
//        System.out.print("\nEnter PIN : ");
//        pin = input.next();
//        if(accnumber.length()!=6){
//            System.out.println("\nAccount Number should have 6 digits length");
//            welcomeScreen();
//        }else if(!accnumber.matches("[0-9]+"))
//        {
//            System.out.println("\nAccount Number should only contains numbers");
//            welcomeScreen();
//        }else if(pin.length()!=6){
//            System.out.println("\nPIN should have 6 digits length");
//            welcomeScreen();
//        }else if(!pin.matches("[0-9]+")){
//            System.out.println("\nPIN should only contains numbers");
//            welcomeScreen();
//        }else{
//            if(Validation.validation(Integer.parseInt(accnumber),pin) != null){
//                user = data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
//                mainMenu(user);
//            }else{
//                System.out.println("Invalid Account Number/PIN");
//                welcomeScreen();
//            }
//        }
//    }

//    public void mainMenu(Account user) {
//        String menu = "3";
//        Scanner input = new Scanner(System.in);
//        System.out.println("----=======MENU=======----");
//        System.out.println("1. withdraw");
//        System.out.println("2. Fund Transfer");
//        System.out.println("3. Exit");
//        System.out.println("4. Transaction History");
//        System.out.print("Please Choose Option[3] : ");
//        menu = input.nextLine();
//        switch (menu) {
//            case "1":
//                withdraw(user);
//                break;
//                case "2":
//                    fundTransfer1(user);
//                    break;
//            case "3": welcomeScreen();
//            break;
//            case "4" : transactionHistory(user);
//                break;
//            default: mainMenu(user);
//            }
//    }

//    public void transactionHistory(Account user){
//         try{
//            for (int i = 0; i < transactionHistories.size(); i++) {
//                if ("Withdraw".equals(transactionHistories.get(i).getType())) {
//                    System.out.println("---==WITHDRAW==---");
//                    System.out.println("Date : " + transactionHistories.get(i).getDate());
//                    System.out.println("Amount : " + transactionHistories.get(i).getAmount());
//                } else {
//                    System.out.println("\n---==FUND TRANSFER==---");
//                    System.out.println("Date : " + transactionHistories.get(i).getDate());
//                    System.out.println("Amount : " + transactionHistories.get(i).getAmount());
//                    System.out.println("To : " + transactionHistories.get(i).getAccountnumber());
//                    int accnumber = transactionHistories.get(i).getAccountnumber();
//                    Account target = data.stream().filter(x -> accnumber == x.getAccountnumber()).findAny().orElse(null);
//                    System.out.println("Name : " + target.getName());
//                }
//            }
//            mainMenu(user);
//        }catch (NullPointerException e){
//             System.out.println("No transaction histories\n");
//             mainMenu(user);
//         }
//    }

//    public void withdraw(Account user){
//        Scanner input = new Scanner(System.in);
//        String menu = "5";
//        System.out.println("----=======WITHDRAW=======----");
//        System.out.println("1. $10");
//        System.out.println("2. $50");
//        System.out.println("3. $100");
//        System.out.println("4. Other");
//        System.out.println("5. Back");
//        System.out.print("Please Choose Option[5] : ");
//        menu = input.nextLine();
//        switch (menu){
//            case "1":
//                if(user.getBalance()<10){
//                    System.out.println("\nInsufficient balance $"+user.getBalance());
//                    withdraw(user);
//                }
//                else{
//                    summary(user,1);
//                }
//                break;
//            case "2":
//                if(user.getBalance()<50){
//                    System.out.println("\nInsufficient balance $"+user.getBalance());
//                    withdraw(user);
//                }else{
//                    summary(user,2);
//                }
//                break;
//            case "3":
//                if(user.getBalance()<100){
//                    System.out.println("\nInsufficient balance $"+user.getBalance());
//                    withdraw(user);
//                }else{
//                    summary(user,3);
//                }
//                break;
//            case "4":
//                summary(user,4);
//                break;
//            case "5":
//                mainMenu(user);
//                break;
//                default: mainMenu(user);
//        }
//    }


//    public void summary(Account user,int choice){
//        Scanner input = new Scanner(System.in);
//        String choose = "2";
//        LocalDateTime datetime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
//        String formatDateTime = datetime.format(formatter);
//        switch (choice){
//            case 1:
//                user.setBalance(user.getBalance()-10);
//                data.set(Storage.getIndex(user.getAccountnumber()),user);
//                transactionHistories.add(new TransactionHistory(thid+1,"Withdraw",0,formatDateTime,10));
//                System.out.println("----=======SUMMARY=======----");
//                System.out.println("Date : "+formatDateTime);
//                System.out.println("Withdraw : $10");
//                System.out.println("Balance : $"+user.getBalance());
//                System.out.println("\n1. Transaction");
//                System.out.println("2. Exit");
//                System.out.print("Choose Option[2] : "); choose = input.nextLine();
//                if("1".equals(choose)){
//                    mainMenu(user);
//                }else if("2".equals(choose)){
//                    welcomeScreen();
//                }else{
//                    welcomeScreen();
//                }
//                break;
//            case 2:
//                user.setBalance(user.getBalance()-50);
//                data.set(Storage.getIndex(user.getAccountnumber()),user);
//                transactionHistories.add(new TransactionHistory(thid+1,"Withdraw",0,formatDateTime,50));
//                System.out.println("----=======SUMMARY=======----");
//                System.out.println("Date : "+formatDateTime);
//                System.out.println("Withdraw : $50");
//                System.out.println("Balance : $"+user.getBalance());
//                System.out.println("\n1. Transaction");
//                System.out.println("2. Exit");
//                System.out.print("Choose Option[2] : "); choose = input.nextLine();
//                if("1".equals(choose)){
//                    mainMenu(user);
//                }else if("2".equals(choose)){
//                    welcomeScreen();
//                }else{
//                    welcomeScreen();
//                }
//                break;
//            case 3:
//                user.setBalance(user.getBalance()-100);
//                data.set(Storage.getIndex(user.getAccountnumber()),user);
//                transactionHistories.add(new TransactionHistory(thid+1,"Withdraw",0,formatDateTime,100));
//                System.out.println("----=======SUMMARY=======----");
//                System.out.println("Date : "+formatDateTime);
//                System.out.println("Withdraw : $100");
//                System.out.println("Balance : $"+user.getBalance());
//                System.out.println("\n1. Transaction");
//                System.out.println("2. Exit");
//                System.out.print("Choose Option[2] : "); choose = input.nextLine();
//                if("1".equals(choose)){
//                    mainMenu(user);
//                }else if("2".equals(choose)){
//                    welcomeScreen();
//                }else{
//                    welcomeScreen();
//                }
//                break;
//            case 4:
//                System.out.println("----=======SUMMARY=======----");
//                System.out.print("Enter amount to withdraw : ");
//                String value = input.next();
//                if(!value.matches("[0-9]+") && Double.parseDouble(value)%10 != 0){
//                    System.out.print("\nInvalid ammount");
//                    summary(user,choice);
//                }else if(Double.parseDouble(value) >1000){
//                    System.out.print("\nMaximum amount to withdraw is $1000");
//                    summary(user,choice);
//                }else if(user.getBalance()<Double.parseDouble(value)){
//                    System.out.print("\nInsufficient balance $"+value);
//                    withdraw(user);
//                }
//                user.setBalance(user.getBalance()-Double.parseDouble(value));
//                data.set(Storage.getIndex(user.getAccountnumber()),user);
//                transactionHistories.add(new TransactionHistory(thid+1,"Withdraw",0,formatDateTime,Double.parseDouble(value)));
//                System.out.println("\nDate : "+formatDateTime);
//                System.out.println("Withdraw : $"+value);
//                System.out.println("Balance : $"+user.getBalance());
//                System.out.println("\n1. Transaction");
//                System.out.println("2. Exit");
//                System.out.print("Choose Option[2] : "); choose = input.nextLine();
//                if("1".equals(choose)){
//                    mainMenu(user);
//                }else if("2".equals(choose)){
//                    welcomeScreen();
//                }else{
//                    welcomeScreen();
//                }
//                break;
//        }
//    }

//    public void fundTransfer1(Account user){
//        Scanner input = new Scanner(System.in);
//        System.out.println("----=======FUND TRANSFER=======----");
//        System.out.println("Please enter destination account and \n" +
//                "press enter to continue or \n" +
//                "press cancel (Esc) to go back to Transaction: ");
//        String accnumber = input.next();
//        if(!accnumber.matches("[0-9]+")){
//            System.out.println("\nInvalid account");
//            fundTransfer1(user);
//        }else {
//            Account target = data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
//            if(target == null){
//                System.out.println("\nInvalid account");
//                fundTransfer1(user);
//            }else{
//                fundTransfer2(user,accnumber);
//            }
//        }
//    }
//
//    public void fundTransfer2(Account user,String accnumber){
//        Scanner input = new Scanner(System.in);
//        System.out.println("----=======FUND TRANSFER=======----");
//        System.out.println("Please enter transfer amount and \n" +
//                "press enter to continue or \n" +
//                "press cancel (Esc) to go back to Transaction: ");
//        String amount = input.next();
//        if(!amount.matches("[0.0-9]+")){
//            System.out.println("\nInvalid amount");
//            fundTransfer2(user,accnumber);
//        }else if(Double.parseDouble(amount) < 1){
//            System.out.println("\nMinimum amount to withdraw is $1");
//            fundTransfer2(user,accnumber);
//        }else if(Double.parseDouble(amount) > 1000){
//            System.out.println("\nMaximum amount to withdraw is $1000");
//            fundTransfer2(user,accnumber);
//        }else if(user.getBalance()<Double.parseDouble(amount)){
//            System.out.println("\nInsufficient balance $"+amount);
//            fundTransfer2(user,accnumber);
//        }
//        else{
//            fundTransfer3(user,accnumber,amount);
//        }
//    }
//
//    public void fundTransfer3(Account user,String accnumber, String amount){
//        Scanner input = new Scanner(System.in);
//        String refnumber;
//        System.out.println("----=======FUND TRANSFER=======----");
//        System.out.println("Please enter reference number (Optional) and \n" +
//                "press enter to continue or \n" +
//                "press cancel (Esc) to go back to Transaction: ");
//        refnumber = input.next();
//        if(!refnumber.matches("[0-9]+")){
//            System.out.println("\nInvalid Reference Number");
//            fundTransfer3(user,accnumber,amount);
//        }else{
//            fundTransfer4(user,accnumber,amount,refnumber);
//        }
//    }
//
//    public void fundTransfer4(Account user,String accnumber,String amount, String refnumber){
//        LocalDateTime datetime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
//        String formatDateTime = datetime.format(formatter);
//
//        Scanner input = new Scanner(System.in);
//        System.out.println("----=======FUND TRANSFER=======----");
//        System.out.println("Transfer Confirmation");
//        System.out.println("Destination Account \t: "+accnumber);
//        System.out.println("Transfer Amount \t\t: $"+amount);
//        System.out.println("Reference Number \t\t: "+refnumber);
//        System.out.println("1. Confirm Trx\n" +
//                "2. Cancel Trx\n" +
//                "Choose option[2]: ");
//        int choose = input.nextInt();
//        switch (choose){
//            case 1:
//                Account target = data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
//                target.setBalance(target.getBalance() + Double.parseDouble(amount));
//                data.set(Storage.getIndex(Integer.parseInt(accnumber)),target);
//
//                user.setBalance(user.getBalance() - Double.parseDouble(amount));
//                data.set(Storage.getIndex(user.getAccountnumber()),user);
//                transactionHistories.add(new TransactionHistory(thid+1,"Fund Transfer",Integer.parseInt(accnumber),formatDateTime,Double.parseDouble(amount)));
//
//                System.out.println("----=======FUND TRANSFER SUMMARY=======----");
//                System.out.println("Destination Account \t: "+accnumber);
//                System.out.println("Transfer Amount \t\t: $"+amount);
//                System.out.println("Reference Number \t\t: "+refnumber);
//                System.out.println("Balance \t\t: "+user.getBalance());
//                System.out.println("1. Transaction\n" +
//                        "2. Exit\n" +
//                        "Choose option[2]: ");
//                choose = input.nextInt();
//                if(choose == 1){
//                    mainMenu(user);
//                }else{
//                    welcomeScreen();
//                }
//                break;
//            case 2:
//                mainMenu(user);
//                break;
//                default: mainMenu(user);
//        }
//    }
}