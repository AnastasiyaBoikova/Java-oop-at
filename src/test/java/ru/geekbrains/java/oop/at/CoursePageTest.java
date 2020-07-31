package ru.geekbrains.java.oop.at;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.BasePage;
import ru.geekbrains.java.oop.at.page.PageCourse;

@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка главной страницы ")
@Story("Проверка вкладки 'Курсы")
@DisplayName("Проверка страницы Курсы")
public class CoursePageTest extends BaseTest {


    @DisplayName("Проверка блоков страницы Курсы")
    @Test
    @Issue("BUG 100503")
    @TmsLink("Test-103")
    public void coursePage (){
        firefoxDriver.get("https://geekbrains.ru/courses");

        BasePage basePage = new BasePage(firefoxDriver);
              basePage.checkPageName("Курсы");

        PageCourse pageCourse = new PageCourse(firefoxDriver);
            pageCourse.clickCourse();

            pageCourse.getFilter();
            pageCourse.getSample();








    }
}
