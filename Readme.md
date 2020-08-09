# Автоматизация тестирования сайта https://geekbrains.ru/

Это учебный проект созданный в рамках курса "ООП в Java""

Автотесты написаны на сайт https://geekbrains.ru/

## Используемые библиотеки

  - [Selenium](#org.seleniumhq.selenium)
  - [Junit-jupiter](#org.junit.jupiter)
  - [Hamcrest](#org.hamcrest)
  - [Allure-junit5](#io.qameta.allure)
  - [Lombok](#org.projectlombok)
 

## Запуск проекта

mvn clean test allure:serve

### Очистка проекта 

Команда clean отчистит папку target

### Запуск тестов

Команда test запустит автотесты в 4 потока

### Подготовка отчета о тестировании

Команда allure:serve генерирует отчет о тестировании

## Автотест 
### AuthorizationTest

Тестирует успешную авторизацию на сайте https://geekbrains.ru/ и переход на главную страницу сайта

### NavigationTest

Проверяет наличие кнопок на боковой панели и переход при нажатии на них на нужные страницы.
На страницах проверяет наличие блоков заголовок и футтер. 

### SearchTest

Тестирует блок поиска на странице https://geekbrains.ru/events по слову "Java". Проверяет отображение всех блоков на странице и количество контента в них.

### CoursePageTest

На странице https://geekbrains.ru/courses переходит в вкладку "Курсы" и проверяет наличия блоков "Фильтр" и "Обзор"

## Язык написания автотестов

Java 