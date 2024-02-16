package com.scooter;

import com.scooter.pageobject.page.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class QuestionsTest extends BaseTest {
    private final int questionIndex;
    private final String questionText;
    private final String questionAnswer;

    public QuestionsTest(int questionIndex, String questionText, String questionAnswer) {
        this.questionIndex = questionIndex;
        this.questionText = questionText;
        this.questionAnswer = questionAnswer;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {0, "Сколько это стоит? И как оплатить?",
                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {6, "Можно ли отменить заказ?",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
        };
    }

    @Test
    public void checkPositiveQuestionsTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isNquestionDisplayed = new MainPage(driver)
                .isNquestionDisplayed(questionIndex);

        assertTrue(isNquestionDisplayed);


        String actualQuestionText = new MainPage(driver)
                .getTextFromQuestion(questionIndex);

        String questionText = new MainPage(driver)
                .getTextFromQuestion(questionIndex);

        assertEquals(actualQuestionText,questionText);


        String actualQuestionAnswer = new MainPage(driver)
                .getTextFromAnswer(questionIndex);

        String questionAnswer = new MainPage(driver)
                .getTextFromAnswer(questionIndex);

        assertEquals(actualQuestionAnswer, questionAnswer);

    }

}
