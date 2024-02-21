package com.scooter.pageobject.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class OrderPageScooter extends BasePage{
    private final By orderDatePlace = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    private final By orderDuration = By.className("Dropdown-placeholder");
    private final By orderComment = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private final By submitButton = By.xpath(".//*[text()='Да']");
    private final By successOrder = By.className("Order_ModalHeader__3FDaJ");

    public OrderPageScooter(WebDriver driver) {super(driver);}

    public OrderPageScooter clickOrderDate() {
        driver.findElement(orderDatePlace).click();
        return this;
    }
    public OrderPageScooter fillOrderDate(String orderDate) {
        clickOrderDate();
        driver.findElement(orderDatePlace).sendKeys(orderDate);
        driver.findElement(orderDatePlace).sendKeys(Keys.ENTER);
        return this;
    }
    public OrderPageScooter clickOrderDuration() {
        driver.findElement(orderDuration).click();
        return this;
    }
    public OrderPageScooter fillOrderDuration(int daysCount) {
        clickOrderDuration();
        final String daysCountTemplate = ".//div[@class='Dropdown-menu']/div[@class='Dropdown-option'][%d]";
        final String daysCountTemplateFull = String.format(daysCountTemplate, daysCount);
        driver.findElement(By.xpath(daysCountTemplateFull)).click();
        return this;
    }
    public OrderPageScooter fillOrderScooterColor(String scooterColor) {

        if (scooterColor == "Черный") {
            driver.findElement(By.id("black")).click();
        }
        if (scooterColor == "Серый") {
            driver.findElement(By.id("grey")).click();
        }
        if (scooterColor == "Оба") {
            driver.findElement(By.id("black")).click();
            driver.findElement(By.id("grey")).click();
        }
        return this;
    }
    public OrderPageScooter fillOrderComment(String comment) {
        driver.findElement(orderComment).sendKeys(comment);
        return this;
    }

    public OrderPageScooter clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
    public OrderPageScooter clickSubmitButton() {
        driver.findElement(submitButton).click();
        return this;
    }
    public boolean isOrderSuccess() {
        return driver.findElement(successOrder).isDisplayed();
    }
}
