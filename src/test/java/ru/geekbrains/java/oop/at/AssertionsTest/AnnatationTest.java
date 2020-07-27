package ru.geekbrains.java.oop.at.AssertionsTest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class AnnatationTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("All Hi");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Thr test is open");

    }

    @Timeout(value = 2)
    @DisplayName(" Test №1")
    @Test
    void name() {
        Assertions.assertEquals(2, 1 + 1);
    }

    @RepeatedTest(value = 3)
    @DisplayName("Test №2")
    @Test
    void name2() {
        Assertions.assertEquals(4, 2 * 2);
    }

    @DisplayName("Test №3")
    @Disabled
    @Test
    void name3() {
        Assertions.assertTrue(2 > 0);
    }

    @DisplayName("Test №4")
    @Timeout(value = 2)
    @Test
    void name4() throws InterruptedException {
        sleep(3000);
    }


    @DisplayName("Test №5")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void name5(int a) {
        Assertions.assertNotNull(a);

    }

    @DisplayName("Test №6")
    @ParameterizedTest
    @MethodSource("List")
    void name6(int a) {
        Assertions.assertNotNull(a);

    }

    public static Stream<Integer> List() {
        return Stream.of(1, 2, 3, 4);
    }

    @DisplayName("Test №7")
    @ParameterizedTest
    @MethodSource("listMulti")
    void name7(int a, String b) {
        Assertions.assertNotNull(a);
        Assertions.assertNotNull(b);
    }

    public static Stream<Arguments> listMulti() {
        return Stream.of(
                Arguments.of(1, "Tom"),
                Arguments.of(2, "Rom")
        );

}

    @AfterEach
    void tearDown() {
        System.out.println("The test is closed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All By");
    }


}
