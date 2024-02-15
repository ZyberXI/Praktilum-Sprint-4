package com.scooter.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

//Создали класс основной страницы и наследовали об BasePage - для проброса драйвера
public class MainPage  extends BasePage{
    public static final String URL = "https://qa-scooter.praktikum-services.ru/"; // Адрес сервиса
    private final By firstHeaderOrderButton = By.className("Button_Button__ra12g"); //кнопка заказать в хедере страницы
    private final By secondHomeOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']"); //кнопка заказать в середине страницы
    private final By accordionMenu = By.className("accordion");

    public MainPage(WebDriver driver) {
        super(driver);
    } //передаем драйвер

    public MainPage clickOrderButton(String orderButton) {
        if (orderButton == "first") {
            driver.findElement(firstHeaderOrderButton).click();
        }
        if (orderButton == "second") {
            WebElement element = driver.findElement(secondHomeOrderButton);
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(secondHomeOrderButton).click();
        }
        return this;
    }

    public MainPage clickNquestion (int questionNumber) {

        WebElement element = driver.findElement(accordionMenu);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        final String accordionNquestionTemplate = ".//div[@id='accordion__heading-%d'][@aria-controls='accordion__panel-13']";
        final String accordionNquestionFullTemplate = String.format(accordionNquestionTemplate, questionNumber);

        driver.findElement(accordionMenu);
        driver.findElement(By.id(accordionNquestionFullTemplate));
        driver.findElement(By.id(accordionNquestionFullTemplate)).click();

        return this;
    }
}
//
//    public void testclick() {
//        WebElement element = driver.findElement(By.className("accordion"));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//        driver.findElement(By.xpath(".//div[@class='accordion__button']"));
//    }
//
//    public clickQuestionByIndex(int questionNumber) {
//        driver.findElement(By.className("accordion")).get(questionNumber).click();
//    }
//
//    public getTextQuestionByIndex(int questionNumber) {
//        return
//    }
//
//    public void clickFirstQuestion() {
//        driver.findElement(FirstQuestionButton).click();
//    } //метод клик по первому вопросу
//}
