package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


public class NavigationTest {
    FirefoxDriver firefoxDriver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        firefoxDriver.get("https://geekbrains.ru/events");
    }


    @ParameterizedTest
    @MethodSource("NavigationCheck")
    void check(String a, String b) {
        firefoxDriver.findElement(By.cssSelector(a)).click();
        Assertions.assertEquals(b, firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));

    }

    public static Stream<Arguments> NavigationCheck() {
        return Stream.of(
                Arguments.of("[class=\"svg-icon icon-courses\"]", "Курсы"),
                Arguments.of("[id=nav] [href=\"/events\"]", "Вебинары"),
                Arguments.of("[id=nav] [href=\"/topics\"]", "Форум"),
                Arguments.of("[id=nav] [href=\"/posts\"]", "Блог"),
                Arguments.of("[id=nav] [href=\"/tests\"]", "Тесты"),
                Arguments.of("[id=nav] [href=\"/career\"]", "Карьера")

        );
    }

    @AfterEach
    public void afterEach() {

        firefoxDriver.quit();
    }


}


