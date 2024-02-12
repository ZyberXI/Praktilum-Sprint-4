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
    private final By FirstQuestionButton = By.id("accordion__heading-0"); //Элемент с первым вопросом
    private final By SecondQuestionButton = By.id("accordion__heading-1"); //Элемент со вторым вопросом
    private final By ThirdQuestionButton = By.id("accordion__heading-2"); //Элемент с третьим вопросом
    private final By FourthQuestionButton = By.id("accordion__heading-3"); //Элемент с четвертым вопросом
    private final By FifthQuestionButton = By.id("accordion__heading-4"); //Элемент с пятым вопросом
    private final By SixthQuestionButton = By.id("accordion__heading-5"); //Элемент с шестым вопросом
    private final By SeventhQuestionButton = By.id("accordion__heading-6"); //Элемент с седьмым вопросом
    private final By EighthQuestionButton = By.id("accordion__heading-7"); //Элемент с восьмым вопросом

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

    public void testclick() {
        WebElement element = driver.findElement(By.className("accordion"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(By.xpath(".//div[@class='accordion__button']"));
    }

    public clickQuestionByIndex(int questionNumber) {
        driver.findElement(By.className("accordion")).get(questionNumber).click();
    }

    public getTextQuestionByIndex(int questionNumber) {
        return
    }

    public void clickFirstQuestion() {
        driver.findElement(FirstQuestionButton).click();
    } //метод клик по первому вопросу
    public void clickSecondQuestion() {
        driver.findElement(SecondQuestionButton).click();
    } //метод клик по второму вопросу
    public void clickThirdQuestion() {
        driver.findElement(ThirdQuestionButton).click();
    } //метод клик по тртьему вопросу
    public void clickFourthQuestion() {
        driver.findElement(FourthQuestionButton).click();
    } //метод клик по четвертому вопросу
    public void clickFifthQuestion() {
        driver.findElement(FifthQuestionButton).click();
    } //метод клик по пятому вопросу
    public void clickSixthQuestion() {
        driver.findElement(SixthQuestionButton).click();
    } //метод клик по шестому вопросу
    public void clickSeventhQuestion() {
        driver.findElement(SeventhQuestionButton).click();
    } //метод клик по седьмому вопросу
    public void clickEighthQuestion() {
        driver.findElement(EighthQuestionButton).click();
    } //метод клик по восьмому вопросу
}
