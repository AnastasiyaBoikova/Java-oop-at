package ru.geekbrains.java.oop.at.BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
   public FirefoxDriver firefoxDriver;

    @BeforeEach
    public void beforeEach() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        firefoxDriver = new FirefoxDriver(options);
        firefoxDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        firefoxDriver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
      //  firefoxDriver.get("https://geekbrains.ru/events");

    }

    @AfterEach
    public void afterEach() {

        firefoxDriver.quit();
    }
}
