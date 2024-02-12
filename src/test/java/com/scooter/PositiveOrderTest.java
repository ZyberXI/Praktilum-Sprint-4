package com.scooter;

import com.scooter.pageobject.page.MainPage;
import com.scooter.pageobject.page.OrderPageScooter;
import com.scooter.pageobject.page.OrderPageUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PositiveOrderTest extends BaseTest {
    private final String userName;
    private final String userSurname;
    private final String userAddress;
    private final String userPhone;
    private final String metro;
    private final String orderDate;
    private final int daysCount;
    private final String scooterColor;
    private final String comment;
    private final String orderButton;

    public PositiveOrderTest(String orderButton, String UserName, String UserSurname, String UserAddress,
                             String UserPhone, String metro, String orderDate, int daysCount,
                             String scooterColor, String comment) {
        this.orderButton = orderButton;
        this.userName = UserName;
        this.userSurname = UserSurname;
        this.userAddress = UserAddress;
        this.userPhone = UserPhone;
        this.metro = metro;
        this.orderDate = orderDate;
        this.daysCount = daysCount;
        this.scooterColor = scooterColor;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"first", "Евгений", "Горшков", "г. Санкт-Петербург, Уральская д. 4",
                        "+79999999999", "Сокольники", "03.03.2024", 4, "Оба", "ASAP"},
                {"second", "Петр", "Первый", "г. Москва, Ленина д. 132",
                        "+78765432344", "Парк Победы", "04.04.2024", 6, "Черный", "Ключ под ковриком"},
        };
    }
    @Test
    public void checkPositiveOrderTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        MainPage mainPage = new MainPage(driver)
                .clickOrderButton(orderButton);

        boolean isGetFirstPageResult = new OrderPageUser(driver)
                .fillUserName(userName)
                .fillUserSurname(userSurname)
                .fillUserAddress(userAddress)
                .fillUserMetro(metro)
                .fillUserPhone(userPhone)
                .clickNextButton()
                .isDisplayedNewForm();

        boolean isGetSecondPageResult = new OrderPageScooter(driver)
                .fillOrderDate(orderDate)
                .fillOrderDuration(daysCount)
                .fillOrderScooterColor(scooterColor)
                .fillOrderComment(comment)
                .clickOrderButton()
                .clickSubmitButton()
                .isOrderSuccess();

        assertTrue(isGetFirstPageResult);
        assertTrue(isGetSecondPageResult);
    }
}
