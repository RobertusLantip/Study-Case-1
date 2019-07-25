package com.mitrais.view;

import com.mitrais.model.Account;

import java.util.Scanner;

public class Withdraw {
    public void withdraw(Account user){
        Scanner input = new Scanner(System.in);
        String menu = "5";
        MainMenu mm = new MainMenu();
        Summary s = new Summary();
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
                if(user.getBalance()<10){
                    System.out.println("\nInsufficient balance $"+user.getBalance());
                    withdraw(user);
                }
                else{
                    s.summary(user,1);
                }
                break;
            case "2":
                if(user.getBalance()<50){
                    System.out.println("\nInsufficient balance $"+user.getBalance());
                    withdraw(user);
                }else{
                    s.summary(user,2);
                }
                break;
            case "3":
                if(user.getBalance()<100){
                    System.out.println("\nInsufficient balance $"+user.getBalance());
                    withdraw(user);
                }else{
                    s.summary(user,3);
                }
                break;
            case "4":
                s.summary(user,4);
                break;
            case "5": mm.mainMenu(user);
                break;
            default: mm.mainMenu(user);
        }
    }
}