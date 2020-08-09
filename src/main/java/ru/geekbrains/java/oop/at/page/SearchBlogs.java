package ru.geekbrains.java.oop.at.page;

import io.qameta.allure.Step;
import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.java.oop.at.block.Navigation.Button;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;


public class SearchBlogs extends BasePage {

    // Поиск блоков

    @FindBy(css = "[id=\"professions\"] h2")
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

    private WebDriver driver;

    public SearchBlogs(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public WebElement getContent(Button button) {
        switch (button) {
            case EVENTS: {
                return javaJunior;
            }
            case CAREER: {
                return geekBrains;
            }

        }
        throw new RuntimeException(" Контент блога " + button + " не отпределен");

    }

    @Step("Поиск слова 'Java'")
    public SearchBlogs searchJava(String java) throws InterruptedException {
        buttonSearch.click();
        sendSearch.sendKeys(java);
        sleep(15000);

        //  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        return this;
    }

    @Step("Проверка блоков по количеству контента")
    public SearchBlogs checkBlog(Button button, Matcher<Integer> matcher) {
        switch (button) {
            case PROFESSION: {
                blogProfessions.isDisplayed();
                assertThat(Integer.parseInt(numberProfessions.getText().trim()), matcher);
                return this;
            }
            case COURSES: {
                blogCareer.isDisplayed();
                assertThat(Integer.parseInt(numberCourses.getText().trim()), matcher);

                return this;
            }
            case EVENTS: {
                blogEvents.isDisplayed();
                assertThat(Integer.parseInt(numberEvents.getText().trim()), matcher);

                return this;
            }
            case TOPICS: {
                blogTopics.isDisplayed();
                assertThat(Integer.parseInt(numberForums.getText().trim()),
                        matcher);
                return this;
            }
            case POSTS: {
                blogPosts.isDisplayed();
                assertThat(Integer.parseInt(numberBlog.getText().trim()),
                        matcher);

                return this;
            }
            case TESTS: {
                blogTests.isDisplayed();
                assertThat(Integer.parseInt(numberTests.getText().trim()),
                        matcher);
                return this;
            }
            case PROJECTS: {
                blogCareer.isDisplayed();

                return this;

            }
        }
        throw new RuntimeException(" Блог " + button + " не найден");

    }

    @Step("Открытие страницы {url}")
    public SearchBlogs openUrl(String url) {
        driver.get(url);
        return this;
    }

    @Step("Поиск контента")
    public SearchBlogs searchContent(Button button, Matcher<String> nameContent) {
        assertThat(getContent(button).getText(), nameContent);
        return this;
    }


}
