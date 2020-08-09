package ru.geekbrains.java.oop.at;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.AuthorizationPage;

@Execution(ExecutionMode.CONCURRENT)
@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка авторизации")
@DisplayName("Авторизация")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Успешная авторизация")
    @Test
    @Issue("BUG 100501")
    @TmsLink("Test-101")
    public void auth() {

        new AuthorizationPage(firefoxDriver)
                .openUrl("https://geekbrains.ru/")
                .authorization("zwq20039@cuoly.com", "zwq20039@cuoly.com")
                .checkPageName("Главная");

    }
}
