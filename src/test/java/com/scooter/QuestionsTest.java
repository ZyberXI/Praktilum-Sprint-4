package com.scooter;

import com.scooter.pageobject.page.MainPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class QuestionsTest extends BaseTest {

    private final int questionIndex = 1;



//    public PositiveQuestionsTest(int questionNumber, String questionText, String questionAnswer) {
//        this.questionNumber = questionNumber;
//        this.questionText = questionText;
//        this.questionAnswer = questionAnswer;
//    }

//    @Parameterized.Parameters
//    public static Object[][] data() {
//        return new Object[][]{
//                {1, "Сколько это стоит? И как оплатить?",
//                        "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
//                {5, "Можно ли продлить заказ или вернуть самокат раньше?",
//                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
//        };
//    }




    @Test
    public void checkPositiveQuestionsTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        boolean isNquestionDisplayed = new MainPage(driver)
                .isNquestionDisplayed(questionIndex);

        String questionText = new MainPage(driver)
                .getTextFromQuestion(questionIndex);

        String answerText = new MainPage(driver)
                .getTextFromAnswer(questionIndex);

        assertTrue(isNquestionDisplayed);

        assertEquals("Хочу сразу несколько самокатов! Так можно?",questionText);

        assertEquals("Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", answerText);



    }

}
