package ru.geekbrains.java.oop.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.AuthorizationPage;
@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка авторизации")
@DisplayName("Авторизация")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Успешная авторизация")
    @Test
    @Issue("BUG 100501")
    @TmsLink("Test-101")
    public void auth() {

        firefoxDriver.get("https://geekbrains.ru/");

        String login = "zwq20039@cuoly.com";
        String password = "zwq20039@cuoly.com";

        new AuthorizationPage(firefoxDriver)
                .authorization(login, password)
                .checkPageName("Главная");

    }
}
