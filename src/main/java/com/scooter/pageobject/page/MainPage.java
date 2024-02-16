package com.scooter.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

//Создали класс основной страницы и наследовали об BasePage - для проброса драйвера
public class MainPage  extends BasePage{
    public static final String URL = "https://qa-scooter.praktikum-services.ru/"; // Адрес сервиса
    private final By firstHeaderOrderButton = By.className("Button_Button__ra12g"); //кнопка заказать в хедере страницы
    private final By secondHomeOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"); //кнопка заказать в середине страницы
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

    public boolean isNquestionDisplayed (int questionIndex) {

        WebElement element = driver.findElement(accordionMenu);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

        final String accordionNquestionTemplate = ".//div[@id='accordion__heading-%d']";
        final String accordionNquestionFullTemplate = String.format(accordionNquestionTemplate, questionIndex);

        driver.findElement(accordionMenu);
        driver.findElement(By.xpath(accordionNquestionFullTemplate));
        driver.findElement(By.xpath(accordionNquestionFullTemplate)).click();

        final String answerNquestionTemplate = ".//div[@id='accordion__panel-%d']";
        final String answerNquestionFullTemplate = String.format(answerNquestionTemplate, questionIndex);
        return driver.findElement(By.xpath(answerNquestionFullTemplate)).isDisplayed();
    }

    public String getTextFromQuestion (int questionIndex) {
        final String accordionNquestionTemplate = ".//div[@id='accordion__heading-%d']";
        final String accordionNquestionFullTemplate = String.format(accordionNquestionTemplate, questionIndex);
        return driver.findElement(By.xpath(accordionNquestionFullTemplate)).getText();
    }

    public String getTextFromAnswer (int questionIndex) {
        final String answerNquestionTemplate = ".//div[@id='accordion__panel-%d']";
        final String answerNquestionFullTemplate = String.format(answerNquestionTemplate, questionIndex);
        return driver.findElement(By.xpath(answerNquestionFullTemplate)).getText();
    }


}
