package ru.geekbrains.java.oop.at;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.PageCourse;

@Execution(ExecutionMode.CONCURRENT)
@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка главной страницы ")
@Story("Проверка вкладки 'Курсы")
@DisplayName("Проверка страницы Курсы")
public class CoursePageTest extends BaseTest {


    @DisplayName("Проверка блоков страницы Курсы")
    @Test
    @Issue("BUG 100503")
    @TmsLink("Test-103")
    public void coursePage() {

        new PageCourse(firefoxDriver)
                .openUrl("https://geekbrains.ru/courses")
                .clickCourse()
                .searchFilter()
                .searchSample();

    }
}
