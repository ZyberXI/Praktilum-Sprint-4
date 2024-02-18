package com.scooter;

import com.scooter.pageobject.page.MainPage;
import com.sun.tools.javac.Main;
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
                {1, "Хочу сразу несколько самокатов! Так можно?",
                        "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?",
                        "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?",
                        "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?",
                        "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?",
                        "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?",
                        "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я жизу за МКАДом, привезёте?",
                        "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkPositiveQuestionsTest() {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String actualQuestionText = new MainPage(driver)
                .scrollToQuestions(questionIndex)
                .getTextFromQuestion(questionIndex);

        String actualQuestionAnswer = new MainPage(driver)
                .scrollToQuestions(questionIndex)
                .getTextFromAnswer(questionIndex);

        String questionText = new MainPage(driver)
                .scrollToQuestions(questionIndex)
                .getTextFromQuestion(questionIndex);

        String questionAnswer = new MainPage(driver)
                .scrollToQuestions(questionIndex)
                .getTextFromAnswer(questionIndex);

        assertEquals(actualQuestionText,questionText);
        assertEquals(actualQuestionAnswer, questionAnswer);

    }

}
