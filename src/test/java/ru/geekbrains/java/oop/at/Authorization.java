package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebElement;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.AuthorizationPage;
import ru.geekbrains.java.oop.at.page.BasePage;

@DisplayName("Авторизация")
public class Authorization extends BaseTest {

    @DisplayName("Успешная авторизация")
    @Test
    public void auth() {

        firefoxDriver.get("https://geekbrains.ru/");

        String login = "zwq20039@cuoly.com";
        String password = "zwq20039@cuoly.com";

//        AuthorizationPage authorizationPage = new AuthorizationPage(firefoxDriver);
//
//        authorizationPage.getInputLogin().sendKeys(login);
//        authorizationPage.getInputPassword().sendKeys(password);
//        authorizationPage.getButtonSingIn().click();
//
//        BasePage basePage = new BasePage(firefoxDriver);
//        basePage.checkPageName("Главная");

        new AuthorizationPage(firefoxDriver)
                .authorization(login, password)
                .checkPageName("Главная");

    }
}
