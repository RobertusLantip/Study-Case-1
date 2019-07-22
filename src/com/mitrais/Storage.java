package com.mitrais;

import java.io.*;
import java.util.*;

public class Storage {
    public static List<Account> persons() {
        List<Account> list = new ArrayList<>();
//        Account a = new Account("John Doe",100,"012108",112233);
//        Account b = new Account("Jane Doe",30,"932012",456789);
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Data.csv"))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                list.add(new Account(values[0],Double.parseDouble(values[2]),values[1],Integer.parseInt(values[3])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        list.add(a);
//        list.add(b);
        return list;
    }

    public static boolean validationAN(List<Account> list){
        boolean result = true;
        for(int i = 0; i < list.size(); i++) {
            for(int j = i+1; j < list.size(); j++) {
                if(list.get(i).getAccountnumber() == list.get(j).getAccountnumber()){
                    result = false;
                }
            }
        }
        return result;
    }

    public static boolean validationDuplicate(List<Account> list){
        long distinc = list.stream().distinct().count();
        return list.size() == distinc;
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
