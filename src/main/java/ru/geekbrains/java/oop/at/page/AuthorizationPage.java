package ru.geekbrains.java.oop.at.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    @FindBy(css = "[class=\"form-control\"]")
    private WebElement inputLogin;

    @FindBy(css = "[placeholder=\"Пароль\"]")
    private WebElement inputPassword;

    @FindBy(css = "[id=\"registration-form-button\"]")
    private WebElement buttonSingIn;

    private WebDriver driver;

    public AuthorizationPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @Step("Авторизация с логином : {login} пароль: {password}")
        public BasePage authorization (String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);

        buttonSingIn.click();
        return new BasePage(driver);
    }


    public WebElement getInputLogin() {
        return inputLogin;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public WebElement getButtonSingIn() {
        return buttonSingIn;
    }
}
