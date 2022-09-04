package tests;

import org.junit.Assert;
import org.junit.Test;

public class TestsHomePage extends BaseUISettings {

    @Test
    public void firstQuestionTextCheck() {
        String actual = homePage.clickOnFirstQuestionAndGetAnAnswer();
        String expected = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        Assert.assertEquals("Ответ в первом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void secondQuestionTextCheck() {
        String actual = homePage.clickOnSecondQuestionAndGetAnAnswer();
        String expected = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
        Assert.assertEquals("Ответ во втором вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void thirdQuestionTextCheck() {
        String actual = homePage.clickOnThirdQuestionAndGetAnAnswer();
        String expected = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
        Assert.assertEquals("Ответ в третьем вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void forthQuestionTextCheck() {
        String actual = homePage.clickOnForthQuestionAndGetAnAnswer();
        String expected = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
        Assert.assertEquals("Ответ в четвертом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void fifthQuestionTextCheck() {
        String actual = homePage.clickOnFifthQuestionAndGetAnAnswer();
        String expected = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
        Assert.assertEquals("Ответ в пятом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void sixthQuestionTextCheck() {
        String actual = homePage.clickOnSixthQuestionAndGetAnAnswer();
        String expected = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
        Assert.assertEquals("Ответ в шестом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void seventhQuestionTextCheck() {
        String actual = homePage.clickOnSeventhQuestionAndGetAnAnswer();
        String expected = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
        Assert.assertEquals("Ответ в седьмом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void eighthQuestionTextCheck() {
        String actual = homePage.clickOnEighthQuestionAndGetAnAnswer();
        String expected = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
        Assert.assertEquals("Ответ в восьмом вопросе не соответствует требованию!", expected, actual);
    }

    @Test
    public void scooterLogoDirectsToCorrectURL() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");
        homePage.clickScooterLogo();
        homePage.waitFor5Seconds();
        String currenURL = driver.getCurrentUrl();
        String expectedURL = "https://qa-scooter.praktikum-services.ru/";
        Assert.assertEquals("Ошибка! Логотип самоката должен вести на https://qa-scooter.praktikum-services.ru/", expectedURL, currenURL);
    }

    @Test
    public void yandexLogoDirectsToCorrectURL() {
        String currentURL = homePage.returnHrefAttributeYandexLogo();
        String expectedURL = "https://yandex.ru/";
        Assert.assertEquals("Ошибка! Логотип яндекса должен вести на https://yandex.ru/", expectedURL, currentURL);
    }

    @Test
    public void StatusOfOrderPageCheckWithWrongOrderNumber() {
        homePage.clickOnStatusOfAnOrderButton();
        homePage.waitFor5Seconds();
        homePage.fillInNumberOfOrder("3454354");
        homePage.clickOnGoButton();
        homePage.waitFor5Seconds();
        boolean actualResult = homePage.isWrongNumberOfOrderImageDisplayed();
        Assert.assertEquals("Ошибка! Должно отображаться сообщение о несуществующем заказе с таким номером.",
                true, actualResult);
    }
}
