package ru.geekbrains.java.oop.at;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.page.SearchBlogs;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.*;
import static ru.geekbrains.java.oop.at.block.Navigation.Button.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Тестирование поиска")
public class SearchTest extends BaseTest {


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

    @Epic("Проверка сайта geekbrains.ru")
    @Feature("Проверка поиска")
    @Story("Проверка поиска по слову 'Java' ")
    @DisplayName("Проверка блоков страницы")
    @Test
    @Issue("BUG 100504")
    @TmsLink("Test-104")
    public void Search() throws InterruptedException {

        new SearchBlogs(firefoxDriver)
                .openUrl("https://geekbrains.ru/events")
                .searchJava("Java")
                .checkBlog(PROFESSION, greaterThanOrEqualTo(2))
                .checkBlog(COURSES, greaterThan(15))
                .checkBlog(EVENTS, allOf(greaterThan(180), lessThan(300)))
                .checkBlog(TOPICS, not(350))
                .checkBlog(POSTS, greaterThan(300))
                .checkBlog(TESTS, greaterThan(0))
                .searchContent(EVENTS, equalToIgnoringCase("Java Junior. Что нужно знать для успешного собеседования?"))
                .searchContent(CAREER, containsString("GeekBrains"));


    }


}


