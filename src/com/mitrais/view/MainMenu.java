package com.mitrais.view;

import com.mitrais.model.Account;

import java.util.Scanner;

public class MainMenu {
    public void mainMenu(Account user) {
        String menu = "3";
        WelcomeScreen ws = new WelcomeScreen();
        FundTransfer ft = new FundTransfer();
        Scanner input = new Scanner(System.in);
        TransactionHistory th = new TransactionHistory();
        System.out.println("----=======MENU=======----");
        System.out.println("1. withdraw");
        System.out.println("2. Fund Transfer");
        System.out.println("3. Exit");
        System.out.println("4. Transaction History");
        System.out.print("Please Choose Option[3] : ");
        menu = input.nextLine();
        switch (menu) {
            case "1":
                Withdraw w = new Withdraw();
                w.withdraw(user);
                break;
            case "2":
                ft.fundTransfer1(user);
                break;
            case "3":
            case "" :
                ws.welcomeScreen();
                break;
            case "4" : th.transactionHistory(user);
                break;
            default: mainMenu(user);
        }
    }
}
