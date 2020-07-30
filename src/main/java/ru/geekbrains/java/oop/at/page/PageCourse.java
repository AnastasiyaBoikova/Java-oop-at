package ru.geekbrains.java.oop.at.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageCourse {


    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement course;

    @FindBy(css = "[id=\"cour-new\"]")
    private WebDriver sample;

    @FindBy(css = "[class=\"course-filter affix-top\"]")
    private WebElement filter;

    public PageCourse(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getCourse() {
        return course;
    }

    public void clickCourse() {
        getCourse().click();

    }

    public WebDriver getSample() {
        return sample;
    }

    public WebElement getFilter() {
        return filter;
    }

    public void checkFilter(){
    }
}
