package ru.geekbrains.java.oop.at;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.block.Navigation;
import ru.geekbrains.java.oop.at.page.BasePage;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка бокового меню")
@Story("Проверка перехода на страницы")
public class NavigationTest extends BaseTest {

    @ParameterizedTest
    @Description("Проверка страницы {namePage}")
    @MethodSource("NavigationCheck")
    @Issue("BUG 100502")
    @TmsLink("Test-102")
    void check(String namePage) {
        firefoxDriver.get("https://geekbrains.ru/events");

        BasePage basePage = new BasePage(firefoxDriver);
        Navigation navigation = new Navigation(firefoxDriver);

        navigation.getButton(namePage).click();
        basePage.checkPageName(namePage);

        basePage.getFooter();
        basePage.getHeader();
    }

    public static Stream<Arguments> NavigationCheck() {
        return Stream.of(
                Arguments.of("Курсы"),
                Arguments.of("Вебинары"),
                Arguments.of("Форум"),
                Arguments.of("Блог"),
                Arguments.of("Тесты"),
                Arguments.of("Карьера")

        );
    }

}


