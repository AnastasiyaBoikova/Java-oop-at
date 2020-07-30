package ru.geekbrains.java.oop.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.BasePage;
import ru.geekbrains.java.oop.at.page.PageCourse;

@DisplayName("Проверка страницы Курсы")
public class CoursePage extends BaseTest {


    @DisplayName("Проверка блоков страницы Курсы")
    @Test
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
