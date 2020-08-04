package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
@DisplayName("Подсчет уникальных слов")
public class ArrayWords extends Poems {

    @DisplayName("Уникальные слова")
    @Test
    public void ArrayWords() {

        Set<String> uniqueWords = new HashSet<>(arrayWords);

        System.out.println("Количество слов в коллекции " + arrayWords.size());
        System.out.println("Уникальные слова " + uniqueWords.toString());
        System.out.println("Количество уникальных слов " + uniqueWords.size());


        for (String word : uniqueWords) {

            System.out.println("'" + word + "'" + " встречается " + Collections.frequency(arrayWords, word) + " раз");

        }
    }

}
