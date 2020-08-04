package ru.geekbrains.java.oop.at;

import org.hamcrest.MatcherAssert;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Poems {

    String poems = " Тише, тише, тише, тише,\n" +
            "\n" +
            "Шелестят на крыше мыши.\n" +
            "\n" +
            "Под мышиным серым флагом\n" +
            "\n" +
            "Маршируют шаг за шагом.\n" +
            "\n" +
            "Впереди идут старшины,\n" +
            "\n" +
            "Запевают гимн мышиный:\n" +
            "\n" +
            "Тише, тише, тише, тише,\n" +
            "\n" +
            "Шаг ровней держите, мыши!\n" +
            "\n" +
            "Люди сыты, кошки сыты,\n" +
            "\n" +
            "Для мышей столы накрыты.\n" +
            "\n" +
            "Затихает шорох шинный.\n" +
            "\n" +
            "Наступает шаг мышиный.\n" +
            "\n" +
            "Ночью пусть пируют мыши.\n" +
            "\n" +
            "Тише, тише, тише, тише! ";

    String[] arr = wordList(poems.toLowerCase());
    List<String> arrayWords = Arrays.asList(arr);

    public static String[] wordList(String line) {
        return line.trim().split("[,;:.!?\\s]+");
    }

}
