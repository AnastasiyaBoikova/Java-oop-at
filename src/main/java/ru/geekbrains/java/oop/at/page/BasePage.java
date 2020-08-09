package ru.geekbrains.java.oop.at.page;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    private WebDriver driver;

    public BasePage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id='top-menu']")
    private WebElement header;

    @FindBy(css = "[class=\"site-footer\"]")
    private WebElement footer;

    @FindBy(css = "[id=\"top-menu\"] h2")
    private WebElement pageName;

    @Step("Проверка заголовка страницы")
    public BasePage checkPageName (String name){
        Assertions.assertEquals(name, pageName.getText());
        return this;
    }

    @Step("Проверка заголовка")
    public BasePage checkHeader() {
        header.isDisplayed();
        return this;
    }


    @Step("Проверка футера")
    public BasePage checkFooter() {
        footer.isDisplayed();
        return this;
    }

    @Step("Открытие страницы {url}")
    public BasePage openUrl(String url) {
        driver.get(url);
        return this;
    }
}