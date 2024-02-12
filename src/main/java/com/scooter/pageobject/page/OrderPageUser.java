package com.scooter.pageobject.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;


public class OrderPageUser extends BasePage{

    private final By userName = By.xpath(".//*[@placeholder='* Имя']");
    private final By userSurname = By.xpath(".//*[@placeholder='* Фамилия']");
    private final By userAddress = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    private final By userPhone = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public OrderPageUser(WebDriver driver) {
        super(driver);
    }
    public OrderPageUser clickUserName() {
        driver.findElement(userName).click();
        return this;
    }
    public OrderPageUser fillUserName(String name) {
        clickUserName();
        driver.findElement(userName).sendKeys(name);
        return this;
    }
    public OrderPageUser clickUserSurname() {
        driver.findElement(userSurname).click();
        return this;
    }
    public OrderPageUser fillUserSurname(String surname) {
        clickUserSurname();
        driver.findElement(userSurname).sendKeys(surname);
        return this;
    }
    public OrderPageUser clickUserAddress() {
        driver.findElement(userAddress).click();
        return this;
    }
    public OrderPageUser fillUserAddress(String address) {
        clickUserAddress();
        driver.findElement(userAddress).sendKeys(address);
        return this;
    }
    public OrderPageUser fillUserMetro(String metro) {
        final String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        final String metroFullTemplate = String.format(metroOptionTemplate, metro);
        driver.findElement(By.className("select-search__input")).sendKeys(metro);
        driver.findElement(By.xpath(metroFullTemplate));
        driver.findElement(By.xpath(metroFullTemplate)).click();
        return this;
    }
    public OrderPageUser clickUserPhone() {
        driver.findElement(userPhone).click();
        return this;
    }
    public OrderPageUser fillUserPhone(String phone) {
        clickUserPhone();
        driver.findElement(userPhone).sendKeys(phone);
        return this;
    }
    public OrderPageUser clickNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }
    public boolean isDisplayedNewForm(){
        return driver.findElement(By.xpath(".//*[@class='Order_Header__BZXOb'][text()='Про аренду']")).isDisplayed();
    }
}
