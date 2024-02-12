package com.scooter;

import com.scooter.pageobject.page.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class QuestionsTest extends BaseTest {

    private final String



    public PositiveQuestionsTest(int questionNumber, String questionText, String questionAnswer) {
        this.questionNumber = questionNumber;
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {1, "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {5, "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
        };
    }

    @Test
    public void checkPositiveQuestionsTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MainPage mainPage = new MainPage(driver)

    }

}
