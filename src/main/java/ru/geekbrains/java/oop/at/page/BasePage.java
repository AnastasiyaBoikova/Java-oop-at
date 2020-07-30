package ru.geekbrains.java.oop.at.page;

import org.junit.jupiter.api.Assertions;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {
    public BasePage (WebDriver driver){
        initElements(driver, this);
    }

    @FindBy(css = "[id='top-menu']")
    private WebElement header;

    @FindBy(css = "[class=\"site-footer\"]")
    private WebElement footer;

    @FindBy(css = "[id=\"top-menu\"] h2")
    private WebElement pageName;

    public void checkPageName (String a){
        Assertions.assertEquals(a, pageName.getText());
    }

    public WebElement getHeader() {
        return header;
    }


    public WebElement getFooter() {
        return footer;
    }

    public WebElement getPageName() {
        return pageName;
    }
}