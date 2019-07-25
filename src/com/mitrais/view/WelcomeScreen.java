package com.mitrais.view;

import com.mitrais.model.Account;
import com.mitrais.Storage;
import com.mitrais.Validation;

import java.util.Scanner;

public class WelcomeScreen {
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
            System.out.println("\nAccount Number should have 6 digits length");
            welcomeScreen();
        }else if(!accnumber.matches("[0-9]+"))
        {
            System.out.println("\nAccount Number should only contains numbers");
            welcomeScreen();
        }else if(pin.length()!=6){
            System.out.println("\nPIN should have 6 digits length");
            welcomeScreen();
        }else if(!pin.matches("[0-9]+")){
            System.out.println("\nPIN should only contains numbers");
            welcomeScreen();
        }else{
            if(Validation.validation(Integer.parseInt(accnumber),pin) != null){
                user = Storage.data.stream().filter(x -> Integer.parseInt(accnumber) == x.getAccountnumber()).findAny().orElse(null);
                MainMenu mm = new MainMenu();
                mm.mainMenu(user);
            }else{
                System.out.println("Invalid Account Number/PIN");
                welcomeScreen();
            }
        }
    }
}
