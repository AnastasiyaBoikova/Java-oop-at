package ru.geekbrains.java.oop.at;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.util.concurrent.TimeUnit;


public class NavigationTest {
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

    @Test

    public void Courses() {

        firefoxDriver.findElement(By.cssSelector("[class=\"svg-icon icon-courses\"]")).click();
        Assertions.assertEquals("Курсы", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_application\"]"));
    }

    @Test
    public void Events() {
        firefoxDriver.findElement(By.cssSelector("[id=nav] [href=\"/events\"]")).click();
        Assertions.assertEquals("Вебинары", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_flexbox\"]"));

    }

    @Test
    public void Topics() {
        firefoxDriver.findElement(By.cssSelector("[id=nav] [href=\"/topics\"]")).click();
        Assertions.assertEquals("Форум", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_flexbox\"]"));

    }

    @Test
    public void Posts() {
        firefoxDriver.findElement(By.cssSelector("[id=nav] [href=\"/posts\"]")).click();
        Assertions.assertEquals("Блог", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_application\"]"));

    }

    @Test
    public void Tests() {
        firefoxDriver.findElement(By.cssSelector("[id=nav] [href=\"/tests\"]")).click();
        Assertions.assertEquals("Тесты", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_flexbox\"]"));

    }

    @Test
    public void Career() {
        firefoxDriver.findElement(By.cssSelector("[id=nav] [href=\"/career\"]")).click();
        Assertions.assertEquals("Карьера", firefoxDriver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        firefoxDriver.findElement(By.cssSelector("[class=\"site-footer\"]"));
        firefoxDriver.findElement(By.cssSelector("[class=\"gb-header__content gb-top-menu__content_flexbox\"]"));

    }


    @AfterEach
    public void afterEach() {

        firefoxDriver.quit();
    }


}


