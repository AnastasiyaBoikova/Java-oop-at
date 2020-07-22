package ru.geekbrains.java.oop.at;

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

    public void Search() {

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
        Assertions.assertTrue(professionCount >= 2);
        System.out.println("Профессий найдено " + professionCount);

        String Course = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"courses\"] span")).getText();
        int courseCount = Integer.parseInt(Course.trim());
        Assertions.assertTrue(courseCount > 15);
        System.out.println("Курсов найдено " + courseCount);

        String Event = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"webinars\"] span")).getText();
        int eventCount = Integer.parseInt(Event.trim());
        Assertions.assertTrue(eventCount > 180 && eventCount < 300);
        System.out.println("Вебинаров найдено " + eventCount);


        String Blogs = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"blogs\"] span")).getText();
        int blogsCount = Integer.parseInt(Blogs.trim());
        System.out.println("Блогов найдено " + blogsCount);
        Assertions.assertTrue(blogsCount > 300);


        String Forums = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"forums\"] span")).getText();
        int forumsCount = Integer.parseInt(Forums.trim());
        System.out.println("Форумов найдено " + forumsCount);
        Assertions.assertTrue(forumsCount != 350);


        String Tests = firefoxDriver.findElement(By.cssSelector(".search-page-tabs [data-tab=\"tests\"] span")).getText();
        int testsCount = Integer.parseInt(Tests.trim());
        Assertions.assertTrue(testsCount > 0);
        System.out.println("Тестов найдено " + testsCount);

        String text = firefoxDriver.findElementByCssSelector("h3 [href=\"/career/682\"]").getText();
        System.out.println(text + " 111");
        //Assertions.assertEquals("Образовательный портал GeekBrains", text);


    }


    @AfterEach
    public void afterEach() {

        firefoxDriver.quit();
    }


}


