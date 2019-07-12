package com.mitrais;

import java.util.ArrayList;
import java.util.List;

public class Storage {
    public static List<Account> persons() {
        List<Account> list = new ArrayList<>();
        Account a = new Account("John Doe",100,"012108",112233);
        Account b = new Account("Jane Doe",30,"932012",112244);
        list.add(a);
        list.add(b);
        return list;
    }

    public static int getIndex(int accnumber){
        int result = -1;
        for(int i = 0; i<persons().size(); i++){
            if(persons().get(i).getAccountnumber() == accnumber){
                result = i;
            }
        }
        return result;
    }
}
