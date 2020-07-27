package ru.geekbrains.java.oop.at;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import javax.sound.midi.Soundbank;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.*;


public class SearchTest {
    FirefoxDriver firefoxDriver;

    @BeforeEach
    public void beforeEach() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        firefoxDriver.get("https://geekbrains.ru/events");
    }

    //Нажать на кнопку Поиск
//        В поле Поиск ввести текст: java
//        Проверить что на странице:
//        Профессий не менее чем 2
//        Курсов более 15
//        Вебинаров больше чем 180, но меньше 300
//        В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
//        Блогов более 300
//        Форумов не 350
//        Тестов не 0
//        В Проектах и компаниях отображается GeekBrains

    @Test

    public void Search() throws InterruptedException {

        firefoxDriver.findElement(By.cssSelector("[class=\"show-search-form\"]")).click();
        firefoxDriver.findElementByCssSelector("[class=\"search-panel__search-field\"]").sendKeys("java");
        firefoxDriver.findElementByXPath("//h2[text()='Профессии']");
        firefoxDriver.findElementByCssSelector("[data-tab=\"professions\"]");
        firefoxDriver.findElementByXPath("//h2[text()='Курсы']");
        firefoxDriver.findElementByXPath("//h2[text()='Вебинары']");
        firefoxDriver.findElementByXPath("//h2[text()='Курсы']");
        firefoxDriver.findElementByXPath("//h2[text()='Блоги']");
        firefoxDriver.findElementByXPath("//h2[text()='Форум']");
        firefoxDriver.findElementByXPath("//h2[text()='Тесты']");
        firefoxDriver.findElementByXPath("//h2[text()='Проекты и компании']");


        String Profession = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"professions\"] span")).getText();
        int professionCount = Integer.parseInt(Profession.trim());
        MatcherAssert.assertThat(professionCount, greaterThanOrEqualTo(2));

        String Course = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"courses\"] span")).getText();
        int courseCount = Integer.parseInt(Course.trim());
        MatcherAssert.assertThat(courseCount, greaterThan(15));

        String Event = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"webinars\"] span")).getText();
        int eventCount = Integer.parseInt(Event.trim());
        MatcherAssert.assertThat(eventCount, allOf(greaterThan(180), lessThan(300)));


        String Blogs = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"blogs\"] span")).getText();
        int blogsCount = Integer.parseInt(Blogs.trim());
        MatcherAssert.assertThat(blogsCount, greaterThan(300));

        String Forums = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"forums\"] span")).getText();
        int forumsCount = Integer.parseInt(Forums.trim());
        MatcherAssert.assertThat(forumsCount, not(350));

        String Tests = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"tests\"] span")).getText();
        int testsCount = Integer.parseInt(Tests.trim());
        MatcherAssert.assertThat(testsCount, greaterThan(0));

        sleep(10000);

        String text = firefoxDriver.findElementsByCssSelector("[class=\"event__title h3 search_text\"]").get(0).getText();
        System.out.println(text);
        MatcherAssert.assertThat(text, equalToIgnoringCase("Java Junior. Что нужно знать для успешного собеседования?"));

        WebElement gbCompany = firefoxDriver.findElement(By.xpath("//div[@class='company-items']//h3/a[contains(text(),'GeekBrains')]"));
        MatcherAssert.assertThat(gbCompany.getText(), containsString("GeekBrains"));


    }


    @AfterEach
    public void afterEach() {

        firefoxDriver.quit();
    }


}


