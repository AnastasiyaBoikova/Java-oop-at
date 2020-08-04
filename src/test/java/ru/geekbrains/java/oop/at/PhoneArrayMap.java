package ru.geekbrains.java.oop.at;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneArrayMap {


    Map<String, List<Integer>> telDir = new HashMap<>();


//    public void add(String name, int number) {
//        telDir.put(name, new ArrayList<>() );
//    }

    public void add(String name, int number) {
        if (!telDir.containsKey(name)) {
           telDir.put(name, new ArrayList<>());
       }
        telDir.get(name).add(number);
   }

    public void get(String name){
       System.out.println(name + telDir.get(name));

    }
}
