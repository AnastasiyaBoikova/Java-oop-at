package ru.geekbrains.java.oop.at.page;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.PageFactory.initElements;

public class PageCourse {

    private WebDriver driver;
    @Getter
    @FindBy(css = "[id=\"cour-link\"]")
    private WebElement course;

    @FindBy(css = "[id=\"cour-new\"]")
    private WebElement sample;

    @FindBy(css = "[class=\"course-filter affix-top\"]")
    private WebElement filter;

    public PageCourse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);;
    }

    @Step("Нажатие на вкладку 'Курсы'")
    public PageCourse clickCourse() {
        course.click();
        return this;
    }

    @Step("Проверка наличия блока 'выборки'")
    public PageCourse searchSample() {
        sample.isDisplayed();
        return this;
    }

    @Step("Проверка наличия блока 'фильтры' ")
    public PageCourse searchFilter() {
       filter.isDisplayed();
        return this;
    }

    @Step("Открытие страницы {url}")
    public PageCourse openUrl(String url) {
        driver.get(url);
        return this;
    }
}
