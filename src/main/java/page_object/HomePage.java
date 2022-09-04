package page_object;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseSettings {

    //кнопка "Заказать" в хедере
    private final By makeAnOrderHeaderButton = By.xpath(".//button[@class = \"Button_Button__ra12g\" and text() = \"Заказать\"]");
    //кнопка "Статус заказа"
    private final By statusOfAnOrderButton = By.className("Header_Link__1TAG7");
    //поле для введения номера заказа после нажатия кнопки - Статус заказа
    private final By numberOfOrderField = By.xpath(".//div[@class = \"Input_InputContainer__3NykH\"]/input[@placeholder= \"Введите номер заказа\"]");
    //кнопка Go!
    private final By GoButton = By.xpath(".//button[text() = \"Go!\"]");
    //форма, появляющая при заполнении номера заказа правильным значением существующего заказа
    private final By wrongNumberOfOrderImage = By.className("Track_NotFound__6oaoY");
    //кнопка "Да, все привыкли"
    private final By cookieButton = By.id("rcc-confirm-button");

    //вопросы в секции "Вопросы о важном"
    private final By firstQuestion = By.xpath(".//div[text() = \"Сколько это стоит? И как оплатить?\"]");
    private final By secondQuestion = By.xpath(".//div[text() = \"Хочу сразу несколько самокатов! Так можно?\"]");
    private final By thirdQuestion = By.xpath(".//div[text() = \"Как рассчитывается время аренды?\"]");
    private final By forthQuestion = By.xpath(".//div[text() = \"Можно ли заказать самокат прямо на сегодня?\"]");
    private final By fifthQuestion = By.xpath(".//div[text() = \"Можно ли продлить заказ или вернуть самокат раньше?\"]");
    private final By sixthQuestion = By.xpath(".//div[text() = \"Вы привозите зарядку вместе с самокатом?\"]");
    private final By seventhQuestion = By.xpath(".//div[text() = \"Можно ли отменить заказ?\"]");
    private final By eighthQuestion = By.xpath(".//div[text() = \"Я жизу за МКАДом, привезёте?\"]");

    //ответы на вопросы в секции "Вопросы о важном"
    private final By firstAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-0\"]");
    private final By secondAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-1\"]");
    private final By thirdAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-2\"]");
    private final By forthAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-3\"]");
    private final By fifthAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-4\"]");
    private final By sixthAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-5\"]");
    private final By seventhAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-6\"]");
    private final By eighthAnswer = By.xpath(".//div[@class = \"accordion__panel\" and @id = \"accordion__panel-7\"]");

    //логотип «Самоката»
    private final By scooterLogo = By.className("Header_LogoScooter__3lsAR");
    //логотип «Yandex»
    private final By yandexLogo = By.className("Header_LogoYandex__3TSOI");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    @Before
    public void setAddress() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public void clickOnMakeAnOrderHeaderButton() {
        click(makeAnOrderHeaderButton);
    }

    public void clickOnStatusOfAnOrderButton() {
        click(statusOfAnOrderButton);
    }

    public void fillInNumberOfOrder(String number) {
        driver.findElement(numberOfOrderField).sendKeys(number);
    }

    public void clickOnCookieButton() {
        click(cookieButton);
    }

    public String clickOnFirstQuestionAndGetAnAnswer() {
        scroll(firstQuestion);
        this.waitFor5Seconds();
        click(firstQuestion);
        this.waitFor5Seconds();
        return driver.findElement(firstAnswer).getText();
    }

    public String clickOnSecondQuestionAndGetAnAnswer() {
        scroll(secondQuestion);
        this.waitFor5Seconds();
        click(secondQuestion);
        this.waitFor5Seconds();
        return driver.findElement(secondAnswer).getText();
    }

    public String clickOnThirdQuestionAndGetAnAnswer() {
        scroll(thirdQuestion);
        this.waitFor5Seconds();
        click(thirdQuestion);
        this.waitFor5Seconds();
        return driver.findElement(thirdAnswer).getText();
    }

    public String clickOnForthQuestionAndGetAnAnswer() {
        scroll(forthQuestion);
        this.waitFor5Seconds();
        click(forthQuestion);
        this.waitFor5Seconds();
        return driver.findElement(forthAnswer).getText();
    }

    public String clickOnFifthQuestionAndGetAnAnswer() {
        scroll(fifthQuestion);
        this.waitFor5Seconds();
        click(fifthQuestion);
        this.waitFor5Seconds();
        return driver.findElement(fifthAnswer).getText();
    }

    public String clickOnSixthQuestionAndGetAnAnswer() {
        scroll(sixthQuestion);
        this.waitFor5Seconds();
        click(sixthQuestion);
        this.waitFor5Seconds();
        return driver.findElement(sixthAnswer).getText();
    }

    public String clickOnSeventhQuestionAndGetAnAnswer() {
        scroll(seventhQuestion);
        this.waitFor5Seconds();
        click(seventhQuestion);
        this.waitFor5Seconds();
        return driver.findElement(seventhAnswer).getText();
    }

    public String clickOnEighthQuestionAndGetAnAnswer() {
        scroll(eighthQuestion);
        this.waitFor5Seconds();
        click(eighthQuestion);
        this.waitFor5Seconds();
        return driver.findElement(eighthAnswer).getText();
    }

    public void clickCookieButton() {
        click(cookieButton);
    }

    public String returnHrefAttributeYandexLogo() {
        return driver.findElement(yandexLogo).getAttribute("href");

    }

    public void clickScooterLogo() {
        click(scooterLogo);
    }

    public void clickOnGoButton() {
        click(GoButton);
    }

    public boolean isWrongNumberOfOrderImageDisplayed() {
        return driver.findElement(wrongNumberOfOrderImage).isDisplayed();
    }
}
