package ru.geekbrains.java.oop.at.block;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.java.oop.at.page.BasePage;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Navigation extends BasePage {
    private WebDriver driver;

    public Navigation (WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[id=nav] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[id=nav] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[id=nav] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[id=nav] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[id=nav] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[id=nav] [href=\"/career\"]")
    private WebElement buttonCareer;

    @Step("Проверка наличия кнопок {button} на боковой панели")
    public Navigation clickButton(Button button) {
        switch (button) {
            case  COURSES: {
                 buttonCourses.click();
                 return this;
            }
            case EVENTS: {
                 buttonEvents.click();
                return this;

            }
            case TOPICS: {
                buttonTopics.click();
                return this;

            }
            case POSTS: {
                buttonPosts.click();
                return this;

            }
            case TESTS: {
                buttonTests.click();
                return this;

            }
            case CAREER: {
                buttonCareer.click();
                return this;

            }
        }
        throw new RuntimeException(" Кнопка " + button + " не найдена");
    }

    public enum Button {
        PROJECTS("Проекты и компании"),
        PROFESSION("Профессии"),
        COURSES("Курсы"),
        EVENTS("Вебинары"),
        TOPICS("Форум"),
        POSTS("Блог"),
        TESTS("Тесты"),
        CAREER("Карьера");
        private String text;

        Button(String text) {
            this.text = text;

        }
        public String getText() {
            return text;
        }

    }
    @Step("Открытие страницы {url}")
    public Navigation openUrl(String url) {
       driver.get(url);
       return this;
    }

}