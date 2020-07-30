package ru.geekbrains.java.oop.at;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.java.oop.at.BaseTest.BaseTest;

import ru.geekbrains.java.oop.at.page.SearchBlogs;

import static java.lang.Thread.sleep;
import static org.hamcrest.Matchers.*;

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
    @DisplayName("Проверка блоков")
    @Test
    // @MethodSource("SearchBlogs")
    public void Search() throws InterruptedException {

        firefoxDriver.get("https://geekbrains.ru/events");
        SearchBlogs searchBlogs = new SearchBlogs(firefoxDriver);
        searchBlogs.searchJava("Java");

        String[] nameBlog = {"Профессии", "Курсы", "Вебинары", "Блог", "Форум", "Тесты", "Проекты и компании"};
        for (int i = 0; i < nameBlog.length; i++) {

            searchBlogs.searchBlog(nameBlog[i]);
        }

        sleep(10000);

        MatcherAssert.assertThat(searchBlogs.getJavaJunior().getText(),
                equalToIgnoringCase("Java Junior. Что нужно знать для успешного собеседования?"));

        MatcherAssert.assertThat(searchBlogs.getGeekBrains().getText(), containsString("GeekBrains"));
    }


//        firefoxDriver.findElement(By.cssSelector("[class=\"show-search-form\"]")).click()//
//        firefoxDriver.findElementByCssSelector("[class=\"search-panel__search-field\"]").sendKeys("java");
//        firefoxDriver.findElementByXPath("//h2[text()='Профессии']");
//       firefoxDriver.findElementByXPath("//h2[text()='Курсы']");
//        firefoxDriver.findElementByXPath("//h2[text()='Вебинары']");
//        firefoxDriver.findElementByXPath("//h2[text()='Блоги']");
//        firefoxDriver.findElementByXPath("//h2[text()='Форум']");
//        firefoxDriver.findElementByXPath("//h2[text()='Тесты']");
//        firefoxDriver.findElementByXPath("//h2[text()='Проекты и компании']");


//    public static Stream<Arguments> SearchBlogs() {
//        return Stream.of(
//                Arguments.of("Профессии"),
//                Arguments.of("Курсы"),
//                Arguments.of("Вебинары"),
//                Arguments.of("Форум"),
//                Arguments.of("Блог"),
//                Arguments.of("Тесты"),
//                Arguments.of("Проекты и компании")
//
//        );
//    }

}


