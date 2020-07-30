package ru.geekbrains.java.oop.at.page;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sound.midi.Soundbank;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;

public class SearchBlogs {

    // Поиск блоков
    @FindBy(xpath = "//h2[text()='Профессии']")
    private WebElement blogProfessions;

    @FindBy(xpath = "//h2[text()='Курсы']")
    private WebElement blogCourses;

    @FindBy(xpath = "//h2[text()='Вебинары']")
    private WebElement blogEvents;

    @FindBy(xpath = "//h2[text()='Блоги']")
    private WebElement blogTopics;

    @FindBy(xpath = "//h2[text()='Форум']")
    private WebElement blogPosts;

    @FindBy(xpath = "//h2[text()='Тесты']")
    private WebElement blogTests;

    @FindBy(xpath = "//h2[text()='Проекты и компании']")
    private WebElement blogCareer;

// Поиск

    @FindBy(css = "[class=\"show-search-form\"]")
    private WebElement buttonSearch;

    @FindBy(css = "[class=\"search-panel__search-field\"]")
    private WebElement sendSearch;


// Поиск количества элементов в блоке

    @FindBy(css = ".search-page-tabs [data-tab=\"professions\"] span")
    private WebElement numberProfessions;

    @FindBy(css = ".search-page-tabs [data-tab=\"courses\"] span")
    private WebElement numberCourses;

    @FindBy(css = ".search-page-tabs [data-tab=\"webinars\"] span")
    private WebElement numberEvents;

    @FindBy(css = ".search-page-tabs [data-tab=\"blogs\"] span")
    private WebElement numberBlog;

    @FindBy(css = ".search-page-tabs [data-tab=\"forums\"] span")
    private WebElement numberForums;

    @FindBy(css = ".search-page-tabs [data-tab=\"tests\"] span")
    private WebElement numberTests;

    // "Java Junior. Что нужно знать для успешного собеседования?"
    @FindBy(css = "[class=\"event__title h3 search_text\"]")
    private WebElement javaJunior;

    @FindBy(xpath = "//div[@class='company-items']//h3/a[contains(text(),'GeekBrains')]")
    private WebElement geekBrains;


    public SearchBlogs(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

    public WebElement getGeekBrains() {
        return geekBrains;
    }

    public WebElement getJavaJunior() {
        return javaJunior;
    }

    public SearchBlogs searchJava(String java) {
        buttonSearch.click();
        sendSearch.sendKeys(java);
        return this;
    }


    public void searchBlog(String nameBlog) {
        switch (nameBlog) {
            case "Профессии": {

                MatcherAssert.assertThat(Integer.parseInt(numberProfessions.getText().trim()),
                        greaterThanOrEqualTo(2));
                break;
            }
            case "Курсы": {
                MatcherAssert.assertThat(Integer.parseInt(numberCourses.getText().trim()),
                        greaterThan(15));

                break;
            }
            case "Вебинары": {
                MatcherAssert.assertThat(Integer.parseInt(numberEvents.getText().trim()),
                        allOf(greaterThan(180), lessThan(300)));

//                MatcherAssert.assertThat(javaJunior.get(0).getText(),
//                        equalToIgnoringCase("Java Junior. Что нужно знать для успешного собеседования?"));

                break;
            }
            case "Форум": {
                MatcherAssert.assertThat(Integer.parseInt(numberForums.getText().trim()),
                        not(350));
                break;
            }
            case "Блог": {
                MatcherAssert.assertThat(Integer.parseInt(numberBlog.getText().trim()),
                        greaterThan(300));

                break;
            }
            case "Тесты": {
                MatcherAssert.assertThat(Integer.parseInt(numberTests.getText().trim()),
                        greaterThan(0));
                break;
            }
            case "Проекты и компании": {

                System.out.println(getGeekBrains().getText());

              //  MatcherAssert.assertThat(getGeekBrains().getText(), containsString("GeekBrains"));

                break;
            }
            default:

                System.out.println(" Блог " + nameBlog + " не найден");

        }

    }

    public WebElement getSendSearch() {
        return sendSearch;
    }



}
