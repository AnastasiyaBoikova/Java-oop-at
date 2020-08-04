package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@DisplayName("Телефонный Справочник")
public class TelephoneDirectory {


    @Test
    public void TelephoneDir() {

//        TelephoneBook ivanov = new TelephoneBook("Иванов", 890998798);
//        TelephoneBook petrov = new TelephoneBook("Петров", 876543237);
//        TelephoneBook sidorov = new TelephoneBook("Сидоров", 876789061);
//        TelephoneBook petrov2 = new TelephoneBook("Петров", 876543245);
//        TelephoneBook sidorov2 = new TelephoneBook("Сидоров", 876546789);
//
//        List<TelephoneBook> arrayBook = new ArrayList<>();
//
//        arrayBook.add(ivanov);
//        arrayBook.add(petrov);
//        arrayBook.add(sidorov);

        //System.out.println(arrayBook);
//
//        Map<String, TelephoneBook> telDir = new HashMap<>();
//        telDir.put("Петров", petrov);
//        telDir.put("Сидоров", sidorov);
//        telDir.put("Сидоров", sidorov2);
//        System.out.println(telDir);

        PhoneArrayMap phoneArrayMap = new PhoneArrayMap();

        phoneArrayMap.add("Иванов", 987654322);
        phoneArrayMap.add("Иванов", 890998798);
        phoneArrayMap.add("Петров", 876543237);
        phoneArrayMap.add("Сидоров", 876789061);
        phoneArrayMap.add("Петров", 876543245);
        phoneArrayMap.add("Сидоров", 876546789);

        phoneArrayMap.get("Иванов");

    }

}
