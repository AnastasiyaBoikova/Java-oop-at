package ru.geekbrains.java.oop.at.block;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class Navigation {
    public Navigation (WebDriver driver){
        initElements(driver, this);
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

    public WebElement getButton(String nameButton) {
        switch (nameButton) {
            case "Курсы": {
                return buttonCourses;
            }
            case "Вебинары": {
                return buttonEvents;
            }
            case "Форум": {
                return buttonTopics;
            }
            case "Блог": {
                return buttonPosts;
            }
            case "Тесты": {
                return buttonTests;
            }
            case "Карьера": {
                return buttonCareer;
            }
        }
        throw new RuntimeException(" Кнопка " + nameButton + " не найдена");
    }

}