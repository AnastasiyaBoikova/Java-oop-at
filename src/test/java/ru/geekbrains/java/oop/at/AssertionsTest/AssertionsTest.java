package ru.geekbrains.java.oop.at.AssertionsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.StandardProtocolFamily;
import java.util.Scanner;

public class AssertionsTest {


    @Test
    void assertEqualsTest() {
        Assertions.assertEquals(2, 1 + 1);
    }

    @Test
    void assertArrayEqualsTest() {
        int[] dogs = {1, 2, 3, 4, 5};
        int[] cats = {1, 2, 7, 4, 1};
        Assertions.assertArrayEquals(dogs, cats);

    }

    @Test
    void assertTrueTest() {
        int a = 62;
        int b = 10;

        Assertions.assertTrue(a > b, "а меньше в");
    }

    @Test
    void assertNullTest() {
        String a = null;

        Assertions.assertNull(a);
    }

    @Test
    void assertNotNullTest() {
        String a = "cloud ";
        Assertions.assertNotNull(a);

    }

    @Test
    void assertThrowsTest() throws FileNotFoundException {
        File file = new File("src/test/java/ru/geekbrains/java/oop/at/AssertionsTest/resources/txt.txt");

        Assertions.assertThrows(FileNotFoundException.class,
                () -> new Scanner(file));
    }

    @Test
    void assertThrowsTest2() throws FileNotFoundException {

        File file2 = new File("src/test/java/ru/geekbrains/java/oop/at/AssertionsTest/resources/txt1.txt");

        Assertions.assertThrows(FileNotFoundException.class,
                () -> new Scanner(file2));

    }

    @Test
    void assertAllTest() {

        Assertions.assertAll("Проверка файла",
                () -> assertEqualsTest(),

                () -> assertThrowsTest2());

    }

    @Test
    void failTest() {
        int a = 1;
        if (a > 0) {
            System.out.println(" a > 0");
        } else
            Assertions.fail("значение меньше о");

    }
}

