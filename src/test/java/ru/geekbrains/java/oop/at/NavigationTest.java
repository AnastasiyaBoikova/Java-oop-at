package ru.geekbrains.java.oop.at;

import io.qameta.allure.*;
//import jdk.jfr.Description;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import ru.geekbrains.java.oop.at.BaseTest.BaseTest;
import ru.geekbrains.java.oop.at.block.Navigation;
import ru.geekbrains.java.oop.at.block.Navigation.Button;

import java.util.stream.Stream;

@Execution(ExecutionMode.CONCURRENT)
@Epic("Проверка сайта geekbrains.ru")
@Feature("Проверка бокового меню")
@Story("Проверка перехода на страницы")
public class NavigationTest extends BaseTest {


    public static Stream<Button> navigationCheck() {
        return Stream.of(
                Button.COURSES,
                Button.EVENTS,
                Button.TOPICS,
                Button.POSTS,
                Button.TESTS,
                Button.CAREER
        );
    }

    @ParameterizedTest
    @Description("Проверка страницы {namePage}")
    @MethodSource("navigationCheck")
    @Issue("BUG 100502")
    @TmsLink("Test-102")
    public void check(Button button) {

        new Navigation(firefoxDriver)
                .openUrl("https://geekbrains.ru/events")
                .clickButton(button)
                .checkPageName(button.getText())
                .checkFooter()
                .checkHeader();


    }
}


