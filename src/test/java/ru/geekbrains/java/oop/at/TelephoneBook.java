package ru.geekbrains.java.oop.at;

import java.util.ArrayList;
import java.util.List;

public class TelephoneBook {

    private String name;

    private int number;
    List<TelephoneBook> arrayBook = new ArrayList<>();


    public TelephoneBook(String name, int number ) {
        this.name = name;
        this.number = number;
    }



    @Override
    public String toString() {
        return "TelephoneBook{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

}

